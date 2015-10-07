import java.util.PriorityQueue;

public class Turn {
    private int turnNumber;

    public int getTurnNumber () {
        return turnNumber;
    }

    public void nextTurn() {
        turnNumber++;
    }
}