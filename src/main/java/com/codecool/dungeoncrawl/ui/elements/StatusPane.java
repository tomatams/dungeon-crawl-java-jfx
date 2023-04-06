package com.codecool.dungeoncrawl.ui.elements;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 350;
    public static final int RIGHT_PANEL_PADDING = 10;
    private final int FONT_SIZE = 35;
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
        playerNameTextLabel.setFont(new Font("Serif", FONT_SIZE));
        playerNameValueLabel = new Label();
        playerNameValueLabel.setFont(new Font("Serif", FONT_SIZE));
        healthTextLabel = new Label("Health: ");
        healthTextLabel.setFont(new Font("Serif", FONT_SIZE));
        healthValueLabel = new Label();
        healthValueLabel.setFont(new Font("Serif", FONT_SIZE));
        itemTextInInventory = new Label("Items: ");
        itemTextInInventory.setFont(new Font("Serif", FONT_SIZE));
        itemValueInInventory = new Label();
        itemValueInInventory.setFont(new Font("Serif", FONT_SIZE));
    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(playerNameTextLabel, 1, 1);
        ui.add(playerNameValueLabel, 2, 1);

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
