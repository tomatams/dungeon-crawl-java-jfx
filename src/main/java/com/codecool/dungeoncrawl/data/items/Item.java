package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;

import java.util.Map;

public abstract class Item implements Drawable {
    private String name;
    private Cell cell;
    private boolean isPickedUp;

    public Item(String name, Cell cell) {
        this.name = name;
        this.cell = cell;
        this.cell.setItem(this);
        this.isPickedUp = false;
    }

    public void onUse() {

    }

    public void onPickUp() {
        cell.getActor().pickUpItem(this);
        setPickedUp(true);
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }

    public void setPickedUp(boolean pickedUp) {
        isPickedUp = pickedUp;
    }

    public boolean isPickedUp() {
        return isPickedUp;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
