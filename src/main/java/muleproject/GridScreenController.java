import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import java.util.Timer;
import java.util.TimerTask;
import javafx.collections.ObservableList;

/**
 * Controller for GridScreen.
 * @author Christa
 */
public class GridScreenController {

    @FXML
    private Label title;

    @FXML
    private Button townButton;

    @FXML
    private GridPane pane;

    public static ObservableList<Node> buttons;
    private static Button currButton;
    private static int buttonRow;
    private static int buttonCol;
    private LandSelection landPhase;
    private Timer turnTimer;

    @FXML
    private void initialize() {
        buttons = pane.getChildren();
        landPhase = new LandSelection(this);
        turnTimer = new Timer();
        for (int i = 0; i < 4; i++) {
            calculateTime(i);
            String color = MuleProject.players.getPlayer(i).getColor();
            Property[] properties = MuleProject.players.getPlayer(i).getProperties();
            for (int j = 0; j < properties.length; j++) {
                if (properties[j] != null) {
                    Button buttonChoice = (Button) getNodeByRowColumnIndex(properties[j].getRow(), properties[j].getCol(), buttons);
                    buttonChoice.setStyle("-fx-background-color: " + color);
                    buttonChoice.fire();
                }
            }
        }
    }

    //TODO Implement food requirements for different rounds
    private void calculateTime(int i) {
        Player current = MuleProject.players.getPlayer(i);
        if (current instanceof HumanPlayer) {
            long turnTime;
            if (current.getFood() > 3) {
                current.addFood(-3);
                turnTime = 50000L;
            } else if (current.getFood() > 0) {
                current.setFood(0);
                turnTime = 30000L;
            } else {
                turnTime = 5000L;
            }
            turnTimer.schedule(new EndTurn(), turnTime);
        }
    }

    @FXML
    private void colorButtonPress(ActionEvent ev) throws IOException {
        Button b = (Button) ev.getSource();
        int x = GridPane.getRowIndex(b);
        int y = GridPane.getColumnIndex(b);
        Property property = getProperty(x, y);
        if (!property.isBought()) {
            String rawString = landPhase.currentPlayer().getColor();
            b.setStyle("-fx-background-color: " + rawString);
            System.out.println(b.getLayoutX());
            System.out.println(b.getText());
            landPhase.currentPlayer().addProperty(property);
            property.toggleBought();
            landPhase.nextTurn();
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

    private Property getProperty(int x, int y) {
        return MuleProject.propertyGrid[x][y];
    }

    @FXML
    private void endTurnButtonPress() throws IOException {
        landPhase.nextTurn();
    }

    @FXML
    private void townButtonPress() throws IOException {
        Stage dialogStage;
        Parent root;
        dialogStage = (Stage) townButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("TownScreen.fxml"));
        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }


    private class EndTurn extends TimerTask {
        @Override
        public void run() {
            landPhase.nextTurn();
        }
    }

    public void nextScreen() throws IOException {
        Stage dialogStage;
        Parent root;
        dialogStage = (Stage) townButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("TownScreen.fxml"));
        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }
}

