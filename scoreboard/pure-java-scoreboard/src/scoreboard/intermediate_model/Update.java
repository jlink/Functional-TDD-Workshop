package scoreboard.intermediate_model;

public class Update {

    public final ScoreBoard scoreBoard;
    public final String line;

    public Update(ScoreBoard scoreBoard, String line) {

        this.scoreBoard = scoreBoard;
        this.line = line;
    }
}
