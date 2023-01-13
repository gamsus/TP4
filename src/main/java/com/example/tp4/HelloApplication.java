package com.example.tp4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {

        TilePane pane = new TilePane();
        Button button1 = new Button("English version");
        pane.getChildren().add(button1);
        Scene scene = new Scene(pane, 800, 600);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                Game game = new Game();
                Scene scene1 = new Scene(game, 800, 600);
                stage.setScene(scene1);
            }
        });


        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}