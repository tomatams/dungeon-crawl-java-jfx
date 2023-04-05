package com.codecool.dungeoncrawl.ui.elements;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PlayerStage {
    private String playerName;
    private Scene playerScene;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Scene getPlayerScene() {
        return playerScene;
    }

    public void setPlayerScene(Scene playerScene) {
        this.playerScene = playerScene;
    }


    public void initPlayerStage(MainStage mainStage, Stage primaryStage) {
        // set title for the stage
        Stage stage = new Stage();
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
        playerScene = new Scene(stackPane, 300, 100);

        // set the scene
        stage.setScene(playerScene);
        stage.show();

        submit.setOnAction(new EventHandler() {
            @Override
            public void handle(Event arg0) {
                System.out.println(textField.getText());
                playerName = textField.getText();
                primaryStage.setScene(mainStage.getScene());
                mainStage.setPlayerNameLabelText(playerName);
                stage.close();
            }
        });
    }
}
