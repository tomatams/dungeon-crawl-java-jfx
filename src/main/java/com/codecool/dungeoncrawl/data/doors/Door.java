package com.codecool.dungeoncrawl.data.doors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;

public class Door implements Drawable {
    private boolean isOpen = false;
    private Cell cell;

    public Door(Cell cell) {
        this.cell = cell;
        this.cell.setDoor(this);
    }

    private void open() {
        cell.setType(CellType.FLOOR);
        isOpen = true;
    }

    private void close() {
        cell.setType(CellType.WALL);
        isOpen = false;
    }

    @Override
    public String getTileName() {
        return isOpen ? "door-open" : "door-closed";
    }
}
