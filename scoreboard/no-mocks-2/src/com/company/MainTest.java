package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {


    @Test
    void teamASelected() {
        Main.ScoreBoard state = new Main.ScoreBoard(Main.Team.NONE);
        Main.ProcessResult expectedResult = new Main.ProcessResult(new Main.ScoreBoard(Main.Team.A), "Team A selected");

        assertEquals(expectedResult, Main.process("a", state));
    }


}