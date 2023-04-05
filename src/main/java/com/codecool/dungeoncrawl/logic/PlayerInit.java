package com.codecool.dungeoncrawl.logic;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PlayerInit {
    public String getPlayerInfo(Stage stage) {
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
        return textField.getText();
    }
}
