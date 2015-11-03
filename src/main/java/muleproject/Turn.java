import java.util.PriorityQueue;

public class Turn {
    private int turnNumber = 1;
    private int roundNumber = 1;

    public int getTurnNumber() {
        return turnNumber;
    }

    public int getRoundNumber() {
        return (int) turnNumber/4;
    }

    public void nextTurn() {
        turnNumber++;
    }

    public boolean roundCheck () {
        if (roundNumber >= 1 && roundNumber <= 12){
            return true;
        }
        return false;
    }
}