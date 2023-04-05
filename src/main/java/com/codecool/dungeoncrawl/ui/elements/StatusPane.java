package com.codecool.dungeoncrawl.ui.elements;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 200;
    public static final int RIGHT_PANEL_PADDING = 10;
    private GridPane ui;
    private Label healthTextLabel;
    private Label healthValueLabel;

    private Label itemTextInInventory;
    private Label itemValueInInventory;

    private Label playerNameTextLabel;
    private Label playerNameValueLabel;

    public StatusPane() {
        ui = new GridPane();
        playerNameTextLabel = new Label("PlayerName: ");
        playerNameValueLabel = new Label();
        healthTextLabel = new Label("Health: ");
        healthValueLabel = new Label();
        itemTextInInventory = new Label("Items: ");
        itemValueInInventory = new Label();
    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(playerNameTextLabel, 1, 1);
        ui.add(playerNameValueLabel, 0, 1);

        ui.add(healthTextLabel, 1, 2);
        ui.add(healthValueLabel, 2, 2);

        ui.add(itemTextInInventory, 1, 3);
        ui.add(itemValueInInventory, 2, 3);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        return borderPane;
    }

    public void setHealthValue(String text) {
        healthValueLabel.setText(text);
    }

    public void setItemValueInInventory(String text) {
        this.itemValueInInventory.setText(text);
    }

    public void setPlayerNameValueLabel(String text) {
        this.playerNameValueLabel.setText(text);
    }
}
