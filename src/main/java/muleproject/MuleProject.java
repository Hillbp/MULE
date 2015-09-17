/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package muleproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Zach and JT
 */
public class MuleProject extends Application {
    
    private Button startButton;
    public static AllPlayers players;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("M.U.L.E."); //Title of Stage
        StackPane root = new StackPane();
        startButton = new Button("Start"); //Creates button to go from title to settings
        root.getChildren().add(startButton);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
        startButton.setOnAction(e -> primaryStage.setScene(settingScreen));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        players = new AllPlayers();
        launch(args);
    }
    
}
