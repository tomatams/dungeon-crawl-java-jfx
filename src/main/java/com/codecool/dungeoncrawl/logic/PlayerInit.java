package com.codecool.dungeoncrawl.logic;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PlayerInit extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Add name to your character!");
        // set title for the stage
        stage.setTitle("Add a name to your character!");

        // create a textfield
        TextField textField = new TextField();

        // create a stack pane
        StackPane stackPane = new StackPane();

        // add textfield
        stackPane.getChildren().add(textField);

        //Defining the Submit button
        Button submit = new Button("Submit");
        stackPane.getChildren().add(submit);

        // create a scene
        Scene sc = new Scene(stackPane, 300, 100);

        // set the scene
        stage.setScene(sc);
        stage.show();

        submit.setOnAction(new EventHandler() {
            @Override
            public void handle(Event arg0) {
                System.out.println(textField.getText());
                stage.close();
            }
        });
    }
}
