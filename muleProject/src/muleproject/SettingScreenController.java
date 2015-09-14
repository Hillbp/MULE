/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muleproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
;
/**
 * FXML Controller class
 *
 * @author Zach
 */
public class SettingScreenController implements Initializable {

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
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
}
