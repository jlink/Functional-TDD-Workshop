package com.kata;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FooTest {

  @Test
  public void sould_show_inintial_score_without_user_input() {

    // given:
    Stream<String> lines = Stream.of();

    // when:
    List<Effect> actual = Process.process(lines)
        .collect(Collectors.toList());

    // then:

    if (actual.size() != 1) {
      throw new RuntimeException("nope! 1");
    }

    if (!actual.get(0).equals(new ConsoleEffect("000:000"))) {
      throw new RuntimeException("nope! 2");
    }
  }

  @Test
  public void sould_add_one_to_team_A() {
    // given:
    Stream<String> lines = Stream.of("A", "+");

    // when:
    List<Effect> actual = Process.process(lines)
        .collect(Collectors.toList());

    // then:

    if (actual.size() != 2) {
      throw new RuntimeException("nope! 1");
    }

    if (!actual.get(1).equals(new ConsoleEffect("001:000"))) {
      throw new RuntimeException("nope! 2");
    }
  }

  @Test
  public void sould_add_one_to_team_B() {
    // given:
    Stream<String> lines = Stream.of("B", "+");

    // when:
    List<Effect> actual = Process.process(lines)
        .collect(Collectors.toList());

    // then:

    if (actual.size() != 2) {
      throw new RuntimeException("nope! 1");
    }

    if (!actual.get(1).equals(new ConsoleEffect("000:001"))) {
      throw new RuntimeException("nope! 2");
    }
  }

  @Test
  public void sould_add_multiple_points_to_team_A() {
    // given:
    Stream<String> lines = Stream.of("A", "+", "+");

    // when:
    List<Effect> actual = Process.process(lines)
        .collect(Collectors.toList());

    // then:

    if (actual.size() != 3) {
      throw new RuntimeException("nope! 1");
    }

    if (!actual.get(2).equals(new ConsoleEffect("002:000"))) {
      throw new RuntimeException("nope! 2");
    }
  }

}