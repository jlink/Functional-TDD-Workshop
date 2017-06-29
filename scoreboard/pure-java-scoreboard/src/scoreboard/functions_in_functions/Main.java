package scoreboard.functions_in_functions;

import java.util.function.Function;

import static scoreboard.functions_in_functions.Functions.*;
import static scoreboard.functions_in_functions.Functions.LineReader;
import static scoreboard.functions_in_functions.Functions.printScoreBoard;
import static scoreboard.functions_in_functions.Functions.translateInputStringToCommand;
import static scoreboard.functions_in_functions.Functions.updateModelByCommand;


public class Main {

    public static void main(String... args) {

        LineReader impureReader = () -> System.console().readLine();

        LineWriter impureWriter = (line) -> System.out.println(line);

        //J-
        final Function<ScoreBoard, ScoreBoard> nextScoreBoardComputer =
                printScoreBoard(
                    impureWriter,
                    updateModelByCommand(
                            translateInputStringToCommand(
                                    impureReader)));
        //J+
        final ScoreBoard nextScoreBoard = nextScoreBoardComputer.apply(new ScoreBoard());

        // TODO: have a look at Function.compose()
        // LineReader needs andThen and then use that for chaining

        // TODO create function with loop and it gets the function from ScoreBoard to ScoreBoard
        // and runs the loop.
    }
}
