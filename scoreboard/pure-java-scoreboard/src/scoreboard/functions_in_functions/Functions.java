package scoreboard.functions_in_functions;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


public class Functions {

    // TODO how to test without a mocked linereader?
    static Function<ScoreBoard, Object[]> translateInputStringToCommand(LineReader lines) {

        return (ScoreBoard sb) -> {
            String line = lines.get();

            // TODO switch
            return new Object[] { Command2.SELECT_A, sb };
        };
    }


    static Function<ScoreBoard, ScoreBoard> updateModelByCommand(Function<ScoreBoard, Object[]> commands) {

        return
            (old) -> {
            Object[] f = commands.apply(old);
            Command2 c = (Command2) f[0];
            ScoreBoard sb = (ScoreBoard) f[1];

            switch (c) {
                case SELECT_A:
                    return sb.selectTeam(0);
            }

            return null; // TODO ScoreBoard.abort();
        };
    }


    static Function<ScoreBoard, ScoreBoard> printScoreBoard(LineWriter lineWriter,
        Function<ScoreBoard, ScoreBoard> scoreBoard) {

        return (old) -> {
            final ScoreBoard sb = scoreBoard.apply(old);
            lineWriter.accept(sb.line);

            return sb;
        };
    }

    interface LineReader extends Supplier<String> {

        // suppliers providing more than a constant value are impure
    }

    interface LineWriter extends Consumer<String> {

        // consumers have side effects by definition
    }
}
