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

/**
 *
 * @author Zach and JT
 */
public class MuleProject extends Application {
    
    private Button startButton;
    public static AllPlayers players;
    public static Player currentPlayer;
    
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

        for (int turnCount = 1; turnCount <= 12; turnCount++) {
            if (turnCount < 3) {
                initLandGrants();
            } else {
                initLandPurchase();
            }
        }
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
    
    /**
     * This method initiates the land grant phase of a turn. Each player gets to
     * choose a tile for free. Only takes place in the first 2 turns.
     */
    public void initLandGrants() {
        boolean landCheck;
        //Goes through every player's turn
        for (int i = 0; i < 4; i++) {
            //This method gets the player at an index in the array.
            currentPlayer = players.getPlayer(i); //TODO does not exist
            if (currentPlayer.getType().equals("Human")) {
                //TODO: Listen for button press
            } else {
                int landNumValue = (int) ((Math.random() * 45) + 1);
                // Need static method that allows a property to be selected from the board.
                Property landChoice = MapScreenController.getTile(landNumValue);
                if (!landChoice.isBought()) {
                    landChoice.setOwner(currentPlayer);
                    landChoice.toggleBought();
                }
            }
        }
    }

    /**
     * This method initiates the land grant phase of a turn after turn 2. Each player gets to
     * choose a tile and buy it for money.
     */
    public void initLandPurchase() {
        boolean landCheck;
        for (int i = 0; i < 4; i++) {
            //This method gets the player at an index in the array.
            currentPlayer = players.getPlayer(i);
            if (currentPlayer.getType().equals("Human")) {
                //TODO: Listen for button press
            } else {
                int landNumValue = (int) ((Math.random() * 45) + 1);
                // Need static method that allows a property to be selected from the board.
                Property landChoice = MapScreenController.getTile(landNumValue);
                if (!landChoice.isBought() && !(currentPlayer.getMoney() - landChoice.getValue() < 0)) {
                    landChoice.setOwner(currentPlayer);
                    landChoice.toggleBought();
                    currentPlayer.setMoney(currentPlayer.getMoney() - landChoice.getValue());
                }
            }
        }
    }
}
