/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package muleproject;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * Controller for PubScreen.
 * @author Christa
 */
public class PubScreenController {

    private Label title;

    @FXML
    private Button exitButton;
    private Button gambleButton;

    @FXML
    private void initialize() {

    }

    @FXML
    private void gambleButtonPress() throws IOException {
        //TODO insert gambling logic here
    }

    @FXML
    private void exitButtonPress() throws IOException {
        Stage dialogStage;
        dialogStage = (Stage) exitButton.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("TownScreen.fxml"));
        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }
}
