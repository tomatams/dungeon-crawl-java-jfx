package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.logic.GameLogic;
import com.codecool.dungeoncrawl.ui.elements.PlayerStage;
import com.codecool.dungeoncrawl.ui.elements.MainStage;
import com.codecool.dungeoncrawl.ui.keyeventhandler.KeyHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Set;

public class UI {
    private Canvas canvas;
    private GraphicsContext context;

    private MainStage mainStage;
    private GameLogic logic;
    private Set<KeyHandler> keyHandlers;
    private int DISPLAY_WIDTH = 15;
    private int DISPLAY_HEIGHT = 15;
    private PlayerStage playerStage;



    public UI(GameLogic logic, Set<KeyHandler> keyHandlers) {
        this.canvas = new Canvas(
                DISPLAY_WIDTH * Tiles.DRAW_WIDTH,
                DISPLAY_HEIGHT * Tiles.DRAW_WIDTH);
        this.logic = logic;
        this.context = canvas.getGraphicsContext2D();
        context.setImageSmoothing(false);
        this.mainStage = new MainStage(canvas);
        this.keyHandlers = keyHandlers;
        this.playerStage = new PlayerStage();
    }

    public void setUpPain(Stage primaryStage) {
        playerStage.initPlayerStage(mainStage, primaryStage, logic);
        Scene scene = mainStage.getScene();
        primaryStage.setScene(playerStage.getPlayerScene());
        logic.setup();
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        for (KeyHandler keyHandler : keyHandlers) {
            keyHandler.perform(keyEvent, logic.getMap());
        }
        logic.moveAllEnemies();
        refresh();
    }


    public void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Cell playerCell = logic.getPlayerCell();
        int xStart = Math.min(Math.max(0, playerCell.getX()-DISPLAY_WIDTH/2),logic.getMapWidth()-DISPLAY_WIDTH);
        int yStart = Math.min(Math.max(0, playerCell.getY()-DISPLAY_HEIGHT/2),logic.getMapHeight()-DISPLAY_HEIGHT);
        for (int x = xStart; x < xStart+DISPLAY_WIDTH; x++) {
            for (int y = yStart; y < yStart+DISPLAY_HEIGHT; y++) {
                Cell cell = logic.getCell(x, y);
                if (cell.getActor() != null) {
                    Tiles.drawTile(context, cell.getActor(), x-xStart, y-yStart);
                } else if (cell.getItem() != null) {
                    Tiles.drawTile(context, cell.getItem(), x-xStart, y-yStart);
                } else if (cell.getDoor() != null) {
                    Tiles.drawTile(context, cell.getDoor(), x-xStart, y-yStart);
                } else {
                    Tiles.drawTile(context, cell, x-xStart, y-yStart);
                }
            }
        }
        mainStage.setHealthLabelText(logic.getPlayerHealth());
        mainStage.setItemLabelText(logic.getPlayersInventory());
    }
}
