package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

import java.util.Random;

public class Skeleton extends Enemy {
    private final static int BASE_HEALTH = 10;
    private final static int BASE_DAMAGE = 2;
    private Random random = new Random();
    public Skeleton(Cell cell) {
        super(cell);
        this.setHealth(BASE_HEALTH);
        this.setDamage(BASE_DAMAGE);
    }


    public void move() {
        int[][] directions = {{1,0},{0,1},{0,-1},{-1,0},{0,0}};
        int[] randomDirection = directions[random.nextInt(directions.length)];
        super.move(randomDirection[0],randomDirection[1]);
    }
    @Override
    public String getTileName() {
        return "skeleton";
    }
}
