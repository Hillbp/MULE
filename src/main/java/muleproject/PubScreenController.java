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
import java.util.Random;

/**
 * Controller for PubScreen.
 * @author Christa
 */
public class PubScreenController {

    private Label title;
    private Player player;
    private Turn turn;

    @FXML
    private Button exitButton;

    @FXML
    private Button gambleButton;

    @FXML
    private void initialize() {

    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    @FXML
    private void gambleButtonPress() throws IOException {
        Turn curTurn = GridScreenController.turn;
        int i = 0;
        long time = GridScreenController.endTime - System.currentTimeMillis();
        if (time <= 50000 && time >= 37000) {
            i = randInt(0, 200);
        } else if (time < 37000 && time >= 25000) {
            i = randInt(0, 150);
        } else if (time < 25000 && time >= 12000) {
            i = randInt(0, 100);
        } else if (time < 12000 && time >= 0) {
            i = randInt(0, 50);
        }
        if (curTurn.getRoundNumber() == 1 || curTurn.getRoundNumber() == 2 || curTurn.getRoundNumber() == 3) {
            i += 50;
        }
        if (curTurn.getRoundNumber() == 4 || curTurn.getRoundNumber() == 5 || curTurn.getRoundNumber() == 6 || curTurn.getRoundNumber() == 7) {
            i += 100;
        }
        if (curTurn.getRoundNumber() == 8 || curTurn.getRoundNumber() == 9 || curTurn.getRoundNumber() == 10 || curTurn.getRoundNumber() == 11) {
            i += 150;
        }
        if (curTurn.getRoundNumber() == 12) {
            i += 200;
        }
        int m = player.getMoney();
        if (i < 250) {
            player.setMoney(m + i);
        } else {
            player.setMoney(m + 250);
        }
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
