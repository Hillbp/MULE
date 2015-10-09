import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.collections.FXCollections;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class MULEsellDialogController {

    @FXML
    private MenuButton menuButton;

    @FXML
    private Button okButton;

    private Player currentPlayer;
    private Stage dialogStage;
    private boolean okClicked = false;
    private Mule mule = null;

    @FXML
    public void initialize() {
        this.currentPlayer = StoreScreenController.currentPlayer;
        ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
        Mule[] mules = currentPlayer.getMules();
        for (int i = 0; i < mules.length; i++) {
            if (mules[i] != null) {
                MenuItem menuItem = new MenuItem("Mule 1 \n" + "Type: " + mules[i].getType());
                final Mule newMule = mules[i];
                menuItem.setOnAction(e -> {
                    mule = newMule;
                });
            }
        }
        menuButton.getItems().setAll(menuItems);
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isOKClicked() {
        return okClicked;
    }

    public void setMule(Mule m) {
        mule = m;
    }
    @FXML
    private void handleOK() {
        if (mule != null) {
            currentPlayer.removeMule(mule);
            currentPlayer.setMoney(currentPlayer.getMoney() + 100);
            okClicked = true;
            dialogStage.close();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Choose a MULE");
            alert.setHeaderText("Please choose a MULE to sell");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}