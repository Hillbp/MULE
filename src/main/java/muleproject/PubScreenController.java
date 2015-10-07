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
        //TODO insert gambling logic here
        //Money Bonus = Round Bonus * random between 0 and Time Bonus.
        int i;
        if (/*timer from 50-37 seconds*/) {
            i = randInt(0, 200);
        } else if (/*timer from 36-25 seconds*/) {
            i = randInt(0, 150);
        } else if (/*timer from 24-12 seconds*/) {
            i = randInt(0, 100);
        } else if (/*timer from 11-0 seconds*/) {
            i = randInt(0, 50);
        }
        if (turn.getTurnNumber() == 1 || turn.getTurnNumber() == 2 || turn.getTurnNumber() == 3) {
            i += 50;
        }
        if (turn.getTurnNumber() == 4 || turn.getTurnNumber() == 5 || turn.getTurnNumber() == 6 || turn.getTurnNumber() == 7) {
            i += 100;
        }
        if (turn.getTurnNumber() == 8 || turn.getTurnNumber() == 9 || turn.getTurnNumber() == 10 || turn.getTurnNumber() == 11) {
            i += 150;
        }
        if (turn.getTurnNumber() == 12) {
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
