import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import javafx.scene.control.Button;
import java.io.IOException;

public class LandSelection {
    private static int current;
    private GridScreenController controller;

    public LandSelection(GridScreenController controller) {
        current = 0;
        setController(controller);
    }

    public void nextTurn() {
        current++;
        boolean loopCheck = false;
        if (current > 3) {
            current = 0;
            loopCheck = true;
            //endLandPhase();
        }
        if (currentPlayer() instanceof AIPlayer && !loopCheck) {
            moveAI();
        }
    }

    private void setController(GridScreenController controller) {
        this.controller = controller;
    }
    public Player currentPlayer() {
        return MuleProject.players.getPlayer(current);
    }

    private int getTurn() {
        return current;
    }

    private Property getProperty(int x, int y) {
        return MuleProject.propertyGrid[x][y];
    }

    private void moveAI() {
        Player currentPlayer = currentPlayer();
        int xValue = (int) Math.random() * 5;
        int yValue = (int) Math.random() * 9;
        // Need static method that allows a property to be selected from the board.
        Property landChoice = getProperty(xValue, yValue);
        Button buttonChoice = (Button) getNodeByRowColumnIndex(xValue, yValue, GridScreenController.buttons);
        // Property landChoice = GridScreenController.getTile(landNumValue);
        if (!landChoice.isBought() && !(currentPlayer.getMoney() - landChoice.getValue() < 0)) {
            landChoice.setOwner(currentPlayer);
            currentPlayer.addProperty(landChoice);
            landChoice.toggleBought();
            currentPlayer.setMoney(currentPlayer.getMoney() - landChoice.getValue());
            buttonChoice.fire();
            nextTurn();
        } else {
            nextTurn();
        }
    }

    public Node getNodeByRowColumnIndex(int row, int column, ObservableList<Node> children) {
        Node result = null;
        for (Node node : children) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
    return result;
    }

    private void endLandPhase() {
        try {
            controller.nextScreen();
        } catch (IOException e) {

        }
    }

}
