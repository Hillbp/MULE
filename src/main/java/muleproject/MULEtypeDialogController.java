/**
 * Controller for MULE type choice screen.
 * @author Zach Guthrie
 */
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class MULEtypeDialogController {
    
    @FXML
    private Button cancelButton;

    private Stage dialogStage;
    private Mule mule;
    private boolean okClicked = false;

    @FXML
    private void initialize() {

    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the MULE that is being edited in the dialog.
     *
     * @param mule
     */
    public void setMULE(Mule mule) {
        this.mule = mule;
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        StoreScreenController.currentPlayer.removeMule(this.mule);
        dialogStage.close();
    }

    /**
     * Called when the user chooses the food option.
     */
    @FXML
    private void handleFood() {
        if (StoreScreenController.currentPlayer.getMoney() > 125) {
            mule.setType("food");
            StoreScreenController.currentPlayer.addMule(mule);
            dialogStage.close();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Not Enough Money");
            alert.setHeaderText("Not Enough Money for Transcation");
            
            alert.showAndWait();
        }
    }

    /**
     * Called when the user chooses the energy option.
     */
    @FXML
    private void handleEnergy() {
        if (StoreScreenController.currentPlayer.getMoney() > 150) {
            mule.setType("energy");
            StoreScreenController.currentPlayer.addMule(mule);
            dialogStage.close();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Not Enough Money");
            alert.setHeaderText("Not Enough Money for Transcation");
            
            alert.showAndWait();
        }
    }

    /**
     * Called when the user chooses the smithore option.
     */
    @FXML
    private void handleSmithore() {
        if (StoreScreenController.currentPlayer.getMoney() > 175) {
            mule.setType("smithore");
            StoreScreenController.currentPlayer.addMule(mule);
            dialogStage.close();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Not Enough Money");
            alert.setHeaderText("Not Enough Money for Transcation");
            
            alert.showAndWait();
        }
    }
}