import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Controller for GridScreen.
 * @author Christa
 */
public class GridScreenController {

    private Label title;
    private Stage dialogStage = (Stage) title.getScene().getWindow();

    //TODO Implement this method
    public static Property getTile(int i) {
        return null;
    }

    @FXML
    private void initialize() {

    }

    @FXML
    private void handleButtonAction(ActionEvent ae) {
        Button b = (Button) ev.getSource();
        b.setStyle("-fx-background-color: darkblue");
        //b.setStyle("-fx-background-color: " + currentPlayer.getColor() + "");
    }

    @FXML
    private void handleNext() throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("workInProgressScreen.fxml"));
        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    private void setOwner(Player currentPlayer) {
        Button b = (Button) ev.getSource();
        b.setStyle("-fx-background-color: darkblue");
        //b.setStyle("-fx-background-color: " + currentPlayer.getColor() + "");
    }
}