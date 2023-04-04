package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

import java.util.Random;

public class Ghost extends Actor{
    private final static int baseHealth = 20;
    private final static int baseDamage = 1;
    private Random random = new Random();
    public Ghost(Cell cell) {
        super(cell, baseHealth, baseDamage);
    }

    @Override
    public void move() {
        int direction = random.nextInt(5);
        int dx = 0;
        int dy = 0;
        switch (direction) {
            case 1:
                dx = 1;
                break;
            case 2:
                dx = -1;
                break;
            case 3:
                dy = 1;
                break;
            case 4:
                dy = -1;
                break;
        }
        Cell cell = this.getCell();
        Cell nextCell;
        try {
            nextCell = cell.getNeighbor(dx, dy);
        } catch (Exception e) {
            nextCell = cell.getNeighbor(-dx, -dy);
            System.out.println(e);
        }
        if (nextCell.getActor() == null){
            cell.setActor(null);
            nextCell.setActor(this);
            this.setCell(nextCell);
        }
    }
    @Override
    public String getTileName() {
        return "ghost";
    }
}
