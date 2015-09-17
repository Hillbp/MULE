/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package muleproject;

import java.io.IOException;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

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
    
    private Stage dialogStage = (Stage) mapSlider.getScene().getWindow();
    /**
     * Initializes the controller class. Also handles all slider changes.
     */
    @FXML
    public void initialize() {
        Settings.setDifficulty(Settings.Difficulty.EASY);
        Settings.setMapType(Settings.Maptype.STANDARD);
        Settings.setNumPlayers(1);
        
        //Listens for Difficulty Slider value changes.
        difficultySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(
                    ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                if (newValue.equals(1)) {
                    Settings.setDifficulty(Settings.Difficulty.EASY);
                } else if (newValue.equals(2)) {
                    Settings.setDifficulty(Settings.Difficulty.NORMAL);
                } else if (newValue.equals(3)) {
                    Settings.setDifficulty(Settings.Difficulty.TOURNAMENT);
                }
            }
        });
        
        //Listens for MapType Slider value changes.
        mapSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, 
                    Number oldValue, Number newValue) {
                if (newValue.equals(1)) {
                    Settings.setMapType(Settings.Maptype.STANDARD);
                } else if (newValue.equals(2)) {
                    Settings.setMapType(Settings.Maptype.WETLAND);
                } else if (newValue.equals(3)) {
                    Settings.setMapType(Settings.Maptype.MOUNTAIN);
                }
            }
        });
        
        //Listens for PlayerNumber Slider value changes.
        numPlayerSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                Settings.setNumPlayers(newValue.intValue());
           }
        });
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
     * Called when the user clicks ok. Brings up player setting screen.
     */
    @FXML
    private void handleOk() throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("playerSettingScreen.fxml"));
        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }
}
