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
    
    private int numPlayers;
    private Stage dialogStage = (Stage) personName.getScene().getWindow();
    private String tempRace;
    private String tempName;
    private Color tempColor;
    
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
     * Called when the user selects Packer as its race.
     */
    @FXML
    private void handlePacker() {
        tempRace = "Packer";
    }
    
    /**
     * Called when the user selects Spheroid as its race.
     */
    @FXML
    private void handleSpheroid() {
        tempRace = "Spheroid";
    }
    
    /**
     * Called when the user selects Humanoid as its race.
     */
    @FXML
    private void handleHumanoid() {
        tempRace = "Humanoid";
    }
    
    /**
     * Called when the user selects Leggite as its race.
     */
    @FXML
    private void handleLeggite() {
        tempRace = "Leggite";
    }
    
    /**
     * Called when the user selects Flapper as its race.
     */
    @FXML
    private void handleFlapper() {
        tempRace = "Flapper";
    }
    
    /**
     * Called when the user selects Bonzoid as its race.
     */
    @FXML
    private void handleBonzoid() {
        tempRace = "Bonzoid";
    }
    
    /**
     * Called when the user selects Mechtron as its race.
     */
    @FXML
    private void handleMechtron() {
        tempRace = "Mechtron";
    }
    
    /**
     * Called when the user selects Gollumer as its race.
     */
    @FXML
    private void handleGollumer() {
        tempRace = "Gollumer";
    }
}
