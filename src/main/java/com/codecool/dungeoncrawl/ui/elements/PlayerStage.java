package com.codecool.dungeoncrawl.ui.elements;

import com.codecool.dungeoncrawl.logic.GameLogic;
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

    public void initPlayerStage(MainStage mainStage, Stage primaryStage, GameLogic logic) {
        // set title for the stage
        Stage stage = new Stage();

        // create a textfield
        TextField textField = new TextField("Add a name to your character!");

        // create a stack pane
        StackPane stackPane = new StackPane();

        // add textfield
        stackPane.getChildren().add(textField);

        //Defining the Submit button
        Button submit = new Button("Submit");

        submit.setTranslateY(30);
        stackPane.getChildren().add(submit);

        // create a scene
        playerScene = new Scene(stackPane, 200, 100);

        // set the scene
        stage.setScene(playerScene);
        stage.show();

        submit.setOnAction(new EventHandler() {
            @Override
            public void handle(Event arg0) {
                setPlayerName(textField.getText());
                logic.getMap().getPlayer().setPlayerName(playerName);
                mainStage.setPlayerNameLabelText(playerName);
                primaryStage.setScene(mainStage.getScene());
                stage.close();
            }
        });
    }
}
