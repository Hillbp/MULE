import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private void handleBack() throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("workInProgressScreen.fxml"));
        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }
}