package com.company;

import java.io.*;
import java.util.*;
import java.util.function.*;

public class Main {


    public static void main(String[] args) throws IOException {
        loop((line, scoreBoard) ->  process(line, scoreBoard));
    }

    private static void loop(BiFunction<String, ScoreBoard, ProcessResult> handler) throws IOException {
        ScoreBoard currentScoreboard = new ScoreBoard(Team.NONE);
        while(true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            ProcessResult processResult = handler.apply(reader.readLine(), currentScoreboard);
            currentScoreboard = processResult.newState;
            System.out.println(processResult.message);
        }
    }

    static ProcessResult process(String line, ScoreBoard state) {
        return new ProcessResult(new ScoreBoard(Team.A), "Team A selected");
    }

    enum Team {
        A, B, NONE
    }

    static class ScoreBoard {

        Team selectedTeam = Team.NONE;

        public ScoreBoard(Team selectedTeam) {
            this.selectedTeam = selectedTeam;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ScoreBoard that = (ScoreBoard) o;
            return selectedTeam == that.selectedTeam;
        }

        @Override
        public int hashCode() {
            return Objects.hash(selectedTeam);
        }
    }

    static class ProcessResult {
        ScoreBoard newState;
        String message;

        public ProcessResult(ScoreBoard newState, String message) {
            this.newState = newState;
            this.message = message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ProcessResult that = (ProcessResult) o;
            return Objects.equals(newState, that.newState) &&
                    Objects.equals(message, that.message);
        }

        @Override
        public int hashCode() {
            return Objects.hash(newState, message);
        }
    }
}
