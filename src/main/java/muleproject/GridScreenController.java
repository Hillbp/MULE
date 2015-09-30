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

/**
 * Controller for GridScreen.
 * @author Christa
 */
public class GridScreenController {

    private Label title;
    private Stage dialogStage = (Stage) title.getScene().getWindow();
    private static Button currButton;
    private static int buttonRow;
    private static int buttonCol;

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
        currButton = b;
        b.setStyle("-fx-background-color: darkblue");
        //b.setStyle("-fx-background-color: " + MuleProject.currentPlayer.getColor() + "");
        System.out.println(b.getLayoutX());
        System.out.println(b.getText());
        //not sure if this will work
        Node source = (Node)ev.getSource();
        buttonCol = GridPane.getColumnIndex(source);
        buttonRow = GridPane.getRowIndex(source);
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