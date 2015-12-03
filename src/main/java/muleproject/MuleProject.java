import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;




/**
 *
 * @author Zach and JT
 */
public class MuleProject extends Application {
    
    private Button startButton;
    public static AllPlayers players;
    public static Player currentPlayer;
    public static Property[][] propertyGrid;
    public static MediaPlayer mediaPlayer;
    public Turn turn;
    private long startTime;
    private long endTime;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("M.U.L.E."); //Title of Stage
        StackPane root = new StackPane();
        startButton = new Button("Start"); //Creates button to go from title to settings
        root.getChildren().add(startButton);
        Parent newParent;
        newParent = FXMLLoader.load(getClass().getResource("settingScreen.fxml"));
        Scene nextScene = new Scene(newParent);
        startButton.setOnAction(e -> primaryStage.setScene(nextScene));
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
        String path = "The-Human-Abstract-Crossing-The-Rubicon-8-Bit.mp3.mp3";
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
       // mediaView = new MediaView(mediaPlayer);

        propertyGrid = new Property[5][9];
        for (int row = 0; row < propertyGrid.length; row++) {
            for (int col = 0; col < propertyGrid[row].length; col++) {
                int propertyNum = (row * 9) + col + 1;
                propertyGrid[row][col] = new Property(propertyNum, 300, "grass", row, col);
            }
        }
    }
    
    private void calculateTime() {
        startTime = System.currentTimeMillis();
        int req = calcReq();
        if (currentPlayer instanceof HumanPlayer) {
            if (currentPlayer.getFood() >= req) {
                currentPlayer.addFood(-3);
                endTime = startTime + 50000L;
            } else if (currentPlayer.getFood() > 0) {
                currentPlayer.setFood(0);
                endTime = startTime + 30000L;
            } else {
                endTime = startTime + 5000L;
            }
        }
    }

    private int calcReq() {
        int req = 3;
        req = req + turn.getRoundNumber() / 4;
        return req;
    }

    public static Property getProperty(int col, int row) {
        return propertyGrid[row][col];
    }

    public static void clearPlayers() {
        players = new AllPlayers();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        players = new AllPlayers();
        launch(args);
    }
    
}
