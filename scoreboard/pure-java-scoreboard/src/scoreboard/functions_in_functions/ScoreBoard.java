package scoreboard.functions_in_functions;

public class ScoreBoard {

    public int selectedTeam;

    public int scoreTeamA;
    public int scoreTeamB;
    public String line;

    public ScoreBoard selectTeam(int team) {

        ScoreBoard s = new ScoreBoard();
        s.selectedTeam = team;
        s.scoreTeamA = this.scoreTeamA;
        s.scoreTeamB = this.scoreTeamB;
        s.line = "team A selected.";

        // TODO ctor with final fields
        return s;
    }
}
