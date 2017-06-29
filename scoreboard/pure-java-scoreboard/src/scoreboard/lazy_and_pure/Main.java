package scoreboard.lazy_and_pure;

public class Main {

    public static void main(String... args) {

        ListOfCommands commands = ListOfCommands.create();
        commands.reduceOrForEachOrSth(command -> command.executeIO(System.console()));
    }
}
