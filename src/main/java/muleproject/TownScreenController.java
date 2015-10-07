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
 * Controller for TownScreen.
 * @author Christa
 */
public class TownScreenController {

    private Label title;

    @FXML
    private Button backButton;
    private Button pubButton;

    @FXML
    private void initialize() {

    }

    @FXML
    private void handlePub() throws IOException {
        Stage dialogStage;
        dialogStage = (Stage) backButton.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("PubScreen.fxml"));
        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    @FXML
    private void handleBack() throws IOException {
        Stage dialogStage;
        dialogStage = (Stage) backButton.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("GridScreen.fxml"));
        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        dialogStage.show();
    }
}