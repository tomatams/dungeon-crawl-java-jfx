package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.doors.Door;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;
    private List<Door> door;


    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        this.door = new ArrayList<Door>();
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addDoor(Door door) { this.door.add(door); }

    public List<Door> getDoor() { return this.door; }

    public Player getPlayer() {
        return player;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
