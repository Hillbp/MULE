//package muleproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.scene.layout.AnchorPane;
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
        energy.setText("Current energy: " + currentPlayer.getEnergy());
        food.setText("Current food: " + currentPlayer.getFood());
        cash.setText("Current cash: " + currentPlayer.getMoney());
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

    @FXML
    private void handleBuyFood() {
        Stage dialogStage;
        dialogStage = (Stage) exitButton.getScene().getWindow();
        if (currentPlayer.getMoney() - 5 >= 0) {
            currentPlayer.setMoney(currentPlayer.getMoney() - 5);
            currentPlayer.setFood(currentPlayer.getFood() + 1);
            food.setText("Current food: " + currentPlayer.getFood());
            cash.setText("Current cash: " + currentPlayer.getMoney());
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Not Enough Money");
            alert.setHeaderText("Not Enough Money for Transaction");
            
            alert.showAndWait();
        }
    }

    @FXML
    private void handleSellFood() {
        Stage dialogStage;
        dialogStage = (Stage) exitButton.getScene().getWindow();
        if (currentPlayer.getFood() > 0) {
            currentPlayer.setFood(currentPlayer.getFood() - 1);
            currentPlayer.setMoney(currentPlayer.getMoney() + 5);
            food.setText("Current food: " + currentPlayer.getFood());
            cash.setText("Current cash: " + currentPlayer.getMoney());
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Not Enough Food");
            alert.setHeaderText("Not Enough Food for Transaction");
            
            alert.showAndWait();
        }
    }

    @FXML
    private void handleBuyEnergy() {
        Stage dialogStage;
        dialogStage = (Stage) exitButton.getScene().getWindow();
        if (currentPlayer.getMoney() - 10 >= 0) {
            currentPlayer.setMoney(currentPlayer.getMoney() - 10);
            currentPlayer.setEnergy(currentPlayer.getEnergy() + 1);
            energy.setText("Current energy: " + currentPlayer.getEnergy());
            cash.setText("Current cash: " + currentPlayer.getMoney());            
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Not Enough Money");
            alert.setHeaderText("Not Enough Money for Transaction");
            
            alert.showAndWait();
        }
    }

    @FXML
    private void handleSellEnergy() {
        Stage dialogStage;
        dialogStage = (Stage) exitButton.getScene().getWindow();
        if (currentPlayer.getEnergy() > 0) {
            currentPlayer.setEnergy(currentPlayer.getEnergy() - 1);
            currentPlayer.setMoney(currentPlayer.getMoney() + 10);
            energy.setText("Current energy: " + currentPlayer.getEnergy());
            cash.setText("Current cash: " + currentPlayer.getMoney());
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Not Enough Energy");
            alert.setHeaderText("Not Enough Energy for Transaction");
            
            alert.showAndWait();
        }
    }

    @FXML
    private void handleBuyMule() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MuleProject.class.getResource("MULEtypeDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            Stage primaryStage = (Stage) exitButton.getScene().getWindow();
            dialogStage.setTitle("Choose MULE Type");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            MULEtypeDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMule(new Mule());

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
        } catch (IOException e) {

        }
    }

    @FXML
    private void handleSellMule() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MuleProject.class.getResource("MULEsellDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            Stage primaryStage = (Stage) exitButton.getScene().getWindow();
            dialogStage.setTitle("Choose MULE to sell");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            MULEsellDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            //Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
        } catch (IOException e) {

        }
    }
}
