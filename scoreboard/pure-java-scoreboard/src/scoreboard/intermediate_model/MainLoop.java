package scoreboard.intermediate_model;

import static scoreboard.intermediate_model.Pure.computeNextScoreBoard;


public class MainLoop {

    // impure
    public static void main(String... args) {

        ScoreBoard scoreBoard = new ScoreBoard();

        while (scoreBoard.inGame) {
            String readLine = readLine();

            // pure part which changes state to new data
            Update update = computeNextScoreBoard(readLine, scoreBoard);
            scoreBoard = update.scoreBoard;

            String toBePrintedLine = update.line;

            writeLine(toBePrintedLine);
        }
    }


    // impure
    private static String readLine() {

        return System.console().readLine();
    }


    // impure
    private static void writeLine(String toBePrintedLine) {

        System.out.println(toBePrintedLine);
    }
}
