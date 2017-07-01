package com.kata;


import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

class Process {

  static class State {
    String name = "";
    int pointsA = 0;

    public void setTeam(String name) {
      this.name = name;
    }

    public String getTeam() {
      return name;
    }

    public void incrementToA() {
      pointsA++;
    }

    public String calcScore() {
      return "00" + pointsA + ":000";
    }
  }


  public static Stream<Effect> process(Stream<String> lines) {
    State state = new State();
    Stream<ConsoleEffect> initialEffect = Stream.of(new ConsoleEffect("000:000"));

    Function<String, Stream<? extends Effect>> mapInputToEffect = line -> {
      if ("A".equals(line)) {
        state.setTeam("A");
        return Stream.empty();
      } else if ("B".equals(line)) {
        state.setTeam("B");
        return Stream.empty();
      } else {
        String newScore;
        if (state.getTeam().equals("A")) {
          state.incrementToA();
          newScore = state.calcScore();
        }
        else {
          newScore = "000:001";
        }
        return Stream.of(new ConsoleEffect(newScore));
      }
    };
    Stream<Effect> effectStream = lines.flatMap(mapInputToEffect);
    return Stream.concat(initialEffect, effectStream);

  }
}