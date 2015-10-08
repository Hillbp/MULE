//package muleproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.IOException;

/**
 * Controller for StoreScreen.
 * @author Christa
 */
public class StoreScreenController {

    @FXML
    private Button exitButton;

    @FXML
    private Label muleNum;

    @FXML
    private Label cash;

    @FXML
    private Label food;

    @FXML
    private Label energy;

    public static Turn currentTurn;
    public static Player currentPlayer;

    @FXML
    private void initialize() {
        currentTurn = GridScreenController.turn;
        currentPlayer = MuleProject.players.getPlayer(currentTurn.getTurnNumber() % 4);
    }

    @FXML
    private void exitButtonPress() throws IOException {
        Stage dialogStage;
        dialogStage = (Stage) exitButton.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("TownScreen.fxml"));
        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }
}
