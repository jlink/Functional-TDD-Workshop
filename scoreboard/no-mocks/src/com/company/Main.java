package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {


    public static void main(String[] args) throws IOException {

        while(true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            ProcessResult process = process(reader.readLine(), new ScoreBoard(Team.NONE));

            System.out.println(process.message);
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
