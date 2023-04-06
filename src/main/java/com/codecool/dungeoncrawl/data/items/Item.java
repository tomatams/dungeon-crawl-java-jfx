package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.actors.Player;

public abstract class Item implements Drawable {
    private String name;
    private Cell cell;

    public Item(String name, Cell cell) {
        this.name = name;
        this.cell = cell;
        this.cell.setItem(this);
    }

    public void onPickUp() {
        cell.setItem(null);
        if(cell.getActor() instanceof Player player){
            player.pickUpItem(this);
            onUse();
        }
    }

    public abstract void onUse();

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
