import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

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
        //TODO nothing needs to happen here?
    }

    @FXML
    private void colorButtonPress(ActionEvent ev) throws IOException {
        Button b = (Button) ev.getSource();
        b.setStyle("-fx-background-color: darkblue");
        //b.setStyle("-fx-background-color: " + MuleProject.currentPlayer.getColor() + "");
        System.out.println(b.getLayoutX());
        System.out.println(b.getText());
    }

    @FXML
    private void endTurnButtonPress() throws IOException {
        //TODO end currentplayer's turn
    }

    @FXML
    private void townButtonPress() throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("workInProgressScreen.fxml"));
        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }
}