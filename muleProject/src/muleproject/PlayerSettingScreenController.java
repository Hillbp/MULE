/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muleproject;

/**
 * Controller for the playerSettingScreen.
 * @author Zach
 */
import java.io.IOException;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
public class PlayerSettingScreenController {
    
    @FXML
    private ColorPicker colorPicker;
    
    @FXML
    private MenuButton racePicker;
    
    @FXML
    private TextField personName;
    
    @FXML
    private Label playerNum;
    
    private int numPlayers = Settings.getPlayers();
    private Stage dialogStage = (Stage) personName.getScene().getWindow();
    private StringProperty tempRace;
    
    /**
     * Initializes the playerSettingScreen.
     */
    @FXML
    public void initialize() {

    }
            
    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setdialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Called when the user clicks back. Brings up game setting screen.
     */
    @FXML
    private void handleBack() throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("settingScreen.fxml"));
        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }
    
    /**
     * Called when the user clicks next. Brings up an additional setting screen
     * or the map screen when all of the players are made.
     */
    @FXML
    private void handleNext() throws IOException {
        if (isInputValid()) {
            HumanPlayer newPlayer = new HumanPlayer(new SimpleStringProperty(
                    personName.getText()), tempRace, colorPicker.getValue());
            // This is where the player is added to the player array in AllPlayers.
            // This must also increment a value in AllPlayers that keeps track
            // of the number of human players.
            AllPlayers.addPlayer(newPlayer);
            
            // This checks to see if the number of human players in AllPlayers
            // matches the number of human players set by the game. This method
            // must be implemented in AllPlayers.
            if (AllPlayers.playerCount() == numPlayers) {
                
                // Calls the main game screen (work in progress for now.)
                Parent root;
                root = FXMLLoader.load(getClass().getResource(
                        "workInProgressScreen.fxml"));
                Scene scene = new Scene(root);
                dialogStage.setScene(scene);
                dialogStage.show();
            } else {
                
                // Calls an additional player setting screen for the next player.
                Parent root; 
                root = FXMLLoader.load(getClass().getResource(
                        "playerSettingScreen.fxml"));
                Scene scene = new Scene(root);
                dialogStage.setScene(scene);
                dialogStage.show();
            }
        }
    }
    
    /**
     * Called when the user selects Packer as its race.
     */
    @FXML
    private void handlePacker() {
        tempRace = new SimpleStringProperty("Packer");
    }
    
    /**
     * Called when the user selects Spheroid as its race.
     */
    @FXML
    private void handleSpheroid() {
        tempRace = new SimpleStringProperty("Spheroid");
    }
    
    /**
     * Called when the user selects Humanoid as its race.
     */
    @FXML
    private void handleHumanoid() {
        tempRace = new SimpleStringProperty("Humanoid");
    }
    
    /**
     * Called when the user selects Leggite as its race.
     */
    @FXML
    private void handleLeggite() {
        tempRace = new SimpleStringProperty("Leggite");
    }
    
    /**
     * Called when the user selects Flapper as its race.
     */
    @FXML
    private void handleFlapper() {
        tempRace = new SimpleStringProperty("Flapper");
    }
    
    /**
     * Called when the user selects Bonzoid as its race.
     */
    @FXML
    private void handleBonzoid() {
        tempRace = new SimpleStringProperty("Bonzoid");
    }
    
    /**
     * Called when the user selects Mechtron as its race.
     */
    @FXML
    private void handleMechtron() {
        tempRace = new SimpleStringProperty("Mechtron");
    }
    
    /**
     * Called when the user selects Gollumer as its race.
     */
    @FXML
    private void handleGollumer() {
        tempRace = new SimpleStringProperty("Gollumer");
    }
    
    /**
     * Called to check if input on player select screen is valid.
     */
    @FXML
    private boolean isInputValid() {
        
    }
}
