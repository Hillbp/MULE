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
import javafx.collections.ObservableList;

/**
 * Controller for GridScreen.
 * @author Christa
 */
public class GridScreenController {

    @FXML
    private Label title;

    @FXML
    private Button townButton;

    @FXML
    private GridPane pane;

    public static ObservableList<Node> buttons;
    private static Button currButton;
    private static int buttonRow;
    private static int buttonCol;
    private LandSelection landPhase;

    //TODO Implement this method
    public static Property getTile(int i) {
        return null;
    }

    @FXML
    private void initialize() {
        buttons = pane.getChildren();
        landPhase = new LandSelection(this);
        for (int i = 0; i < 4; i++) {
            
        }
    }

    @FXML
    private void colorButtonPress(ActionEvent ev) throws IOException {
        Button b = (Button) ev.getSource();
        currButton = b;
        String rawString = landPhase.currentPlayer().getColor();
        //b.setStyle("-fx-background-color: darkblue");
        b.setStyle("-fx-background-color: " + rawString);
        System.out.println(b.getLayoutX());
        System.out.println(b.getText());
        //not sure if this will work
        Node source = (Node) ev.getSource();
        buttonCol = GridPane.getColumnIndex(source);
        buttonRow = GridPane.getRowIndex(source);
        landPhase.currentPlayer().addProperty(getProperty(buttonRow, buttonCol));
        landPhase.nextTurn();
    }

    private Property getProperty(int x, int y) {
        return MuleProject.propertyGrid[x][y];
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


    private class Exit extends TimerTask {
        @Override
        public void run() {
            int i = 1;
        }
    }

    public void nextScreen() throws IOException {
        Stage dialogStage;
        Parent root;
        dialogStage = (Stage) townButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("TownScreen.fxml"));
        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }
}

