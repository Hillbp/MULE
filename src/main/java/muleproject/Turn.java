import java.util.PriorityQueue;

public class Turn {
    private int turnNumber;
    private int roundNumber;

    public int getTurnNumber () {
        return turnNumber;
    }

    public int getRoundNumber() {
        return (int) turnNumber/4;
    }

    public void nextTurn() {
        turnNumber++;
    }
}