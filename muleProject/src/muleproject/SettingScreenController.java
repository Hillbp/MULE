/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muleproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Zach
 */
public class SettingScreenController {

    @FXML
    private Slider difficultySlider;
    
    @FXML
    private Slider mapSlider;
    
    @FXML
    private Slider numPlayerSlider;
    
    private Stage dialogStage;
    private boolean okClicked = false;
    /**
     * Initializes the controller class.
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
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        okClicked = true;
        dialogStage.close();
    }
    
    /**
     * Called when the user moves the difficulty slider.
     */
    @FXML
    private void handleDiffSlide() {
        if (difficultySlider.valueChangingProperty().equals(true)) {
            if (difficultySlider.valueProperty().equals(1)) {
                Settings.setDifficulty(Settings.Difficulty.EASY);
            } else if (difficultySlider.valueProperty().equals(2)) {
                Settings.setDifficulty(Settings.Difficulty.NORMAL);
            } else {
                Settings.setDifficulty(Settings.Difficulty.TOURNAMENT);
            }
        }
    }
    
    /**
     *  Called when the user moves the maptype slider.
     */
    @FXML
    private void handleMapSlide() {
        if (mapSlider.valueChangingProperty().equals(true)) {
            if (mapSlider.valueProperty().equals(1)) {
                Settings.setMapType(Settings.Maptype.STANDARD);
            } else if (mapSlider.valueProperty().equals(2)) {
                Settings.setMapType(Settings.Maptype.WETLAND);
            } else {
                Settings.setMapType(Settings.Maptype.MOUNTAIN);
            }
        }
    }
    
    /**
     * Called when the user moves the player number slider.
     */
    @FXML
    private void handlePlayerSlide() {
        if (numPlayerSlider.valueChangingProperty().equals(true)) {
            if (numPlayerSlider.valueProperty().equals(1)) {
                Settings.setNumPlayers(1);
            } else if (numPlayerSlider.valueProperty().equals(2)) {
                Settings.setNumPlayers(2);
            } else if (numPlayerSlider.valueProperty().equals(3)) {
                Settings.setNumPlayers(3);
            } else {
                Settings.setNumPlayers(4);
            }
        }
    }
}
