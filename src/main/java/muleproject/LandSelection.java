public class LandSelection {
    private static int current;

    public LandSelection() {
        current = 0;
    }

    public static void nextTurn() {
        current++;
        if (current > 3) {
            current = 0;
        }
    }

    public static Player currentPlayer() {
        return MuleProject.players.getPlayer(current);
    }
}