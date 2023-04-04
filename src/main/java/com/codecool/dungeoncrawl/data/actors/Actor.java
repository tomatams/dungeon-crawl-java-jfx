package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.Map;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;
    private int damage = 2;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public Actor(Cell cell, int health, int damage) {
        this.cell = cell;
        this.cell.setActor(this);
        this.health = health;
        this.damage = damage;
    }

    public void move() {}
    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (!nextCell.getType().equals(CellType.WALL) && nextCell.getActor() == null){
            cell.setActor(null);
            nextCell.setActor(this);
            this.setCell(nextCell);
        }
        if (cell.getItem() != null){
            cell.getItem().onPickUp();
        }
    }

    public void pickUpItem(Item item){}
    public Map<String, Integer> getItemList() {
        return null;
    }

    public int getHealth() {
        return health;
    }

    public Cell getCell() {
        return cell;
    }
    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }

    public void setHealth(int getHealth) {
        this.health = health + getHealth;
    }
}
