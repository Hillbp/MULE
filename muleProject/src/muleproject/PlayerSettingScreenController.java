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
}
