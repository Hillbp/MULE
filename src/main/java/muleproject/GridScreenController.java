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

/**
 * Controller for GridScreen.
 * @author Christa
 */
public class GridScreenController {

    @FXML
    private Label title;

    @FXML
    private Button townButton;

    private static Button currButton;
    private static int buttonRow;
    private static int buttonCol;

    //TODO Implement this method
    public static Property getTile(int i) {
        return null;
    }

    @FXML
    private void initialize() {
        for (int turnCount = 1; turnCount <= 12; turnCount++) {
            if (turnCount < 3) {
                initLandGrants();
            } else {
                initLandPurchase();
            }
        }
    }

    /**
     * This method initiates the land grant phase of a turn. Each player gets to
     * choose a tile for free. Only takes place in the first 2 turns.
     */
    public void initLandGrants() {
        boolean landCheck;
        //Goes through every player's turn
        for (int i = 0; i < 4; i++) {
            //This method gets the player at an index in the array.
            Player currentPlayer = LandSelection.currentPlayer();
            if (currentPlayer instanceof HumanPlayer) {
                //TODO: Listen for button press
                Timer t = new Timer();
                Exit e = new Exit();
                t.schedule(e, 5000L);
            } else {
                int landNumValue = (int) ((Math.random() * 45) + 1);
                Property landChoice = getProperty((int) Math.random()*5, (int) Math.random()*9);
                // Need static method that allows a property to be selected from the board.
                // Property landChoice = Property.getNum(landNumValue);
                if (!landChoice.isBought()) {
                    landChoice.setOwner(currentPlayer);
                    landChoice.toggleBought();
                    LandSelection.nextTurn();
                }
            }
        }
    }
    /**
     * This method initiates the land grant phase of a turn after turn 2. Each player gets to
     * choose a tile and buy it for money.
     */
    public void initLandPurchase() {
        boolean landCheck;
        for (int i = 0; i < 4; i++) {
            //This method gets the player at an index in the array.
            Player currentPlayer = LandSelection.currentPlayer();
            if (currentPlayer instanceof HumanPlayer) {
                //TODO: Listen for button press
                Timer t = new Timer();
                Exit e = new Exit();
                t.schedule(e, 50000L);
            } else {
                int landNumValue = (int) ((Math.random() * 45) + 1);
                // Need static method that allows a property to be selected from the board.
                Property landChoice = getProperty((int) Math.random()*5, (int) Math.random()*9);
                // Property landChoice = GridScreenController.getTile(landNumValue);
                if (!landChoice.isBought() && !(currentPlayer.getMoney() - landChoice.getValue() < 0)) {
                    landChoice.setOwner(currentPlayer);
                    currentPlayer.addProperty(landChoice);
                    landChoice.toggleBought();
                    currentPlayer.setMoney(currentPlayer.getMoney() - landChoice.getValue());
                    LandSelection.nextTurn();
                }
            }
        }
    }

    private class Exit extends TimerTask {
        @Override
        public void run() {
            int i = 1;
        }
    }

    private Property getProperty(int x, int y) {
        return MuleProject.propertyGrid[x][y];
    }

    @FXML
    private void colorButtonPress(ActionEvent ev) throws IOException {
        Button b = (Button) ev.getSource();
        currButton = b;
        String rawString = LandSelection.currentPlayer().getColor();
        //b.setStyle("-fx-background-color: darkblue");
        b.setStyle("-fx-background-color: " + rawString);
        System.out.println(b.getLayoutX());
        System.out.println(b.getText());
        //not sure if this will work
        Node source = (Node) ev.getSource();
        buttonCol = GridPane.getColumnIndex(source);
        buttonRow = GridPane.getRowIndex(source);
        LandSelection.nextTurn();
    }

    @FXML
    private void endTurnButtonPress() throws IOException {
        //TODO end currentplayer's turn
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
}