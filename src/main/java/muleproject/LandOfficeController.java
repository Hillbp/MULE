import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by Alex on 11/2/15.
 */
public class LandOfficeController {

    @FXML
    private Button backButton;
    private Button buyLandButton;
    private Button sellLandButton;

    @FXML
    private void initialize() {

    }

    @FXML
    private void backButtonPress() throws IOException {
        Stage dialogStage;
        dialogStage = (Stage) backButton.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("TownScreen.fxml"));
        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    private void buyLandButtonPress() throws IOException {
        Stage dialogStage;
        dialogStage = (Stage) backButton.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("TownScreen.fxml"));
        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    private void sellLandButtonPress() throws IOException {
        Stage dialogStage;
        dialogStage = (Stage) backButton.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("TownScreen.fxml"));
        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }
}
