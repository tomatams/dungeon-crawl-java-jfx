package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

import java.util.Random;

public class Ghost extends Enemy{
    private final static int BASE_HEALTH = 20;
    private final static int BASE_DAMAGE = 1;
    private int[][] directions = {{1,0},{0,1},{0,-1},{-1,0},{0,0}};
    private Random random = new Random();
    public Ghost(Cell cell) {
        super(cell);
        this.setHealth(BASE_HEALTH);
        this.setDamage(BASE_DAMAGE);
        this.setDirections(directions);
        this.setRandom(random);
    }

    @Override
    public void randomMove() {
        Cell cell = this.getCell();
        Cell nextCell;
        int[] randomDirection = directions[random.nextInt(directions.length)];
        try {
            nextCell = cell.getNeighbor(randomDirection[0], randomDirection[1]);
        } catch (Exception e) {
            nextCell = cell.getNeighbor(-randomDirection[0], -randomDirection[1]);
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
