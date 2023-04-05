package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

import java.util.Random;

public class Scorpion extends Enemy{
    private final static int BASE_HEALTH = 15;
    private final static int BASE_DAMAGE = 2;
    private int[][] directions = {{0,0}};
    private Random random = new Random();
    public Scorpion(Cell cell) {
        super(cell);
        this.setHealth(BASE_HEALTH);
        this.setDamage(BASE_DAMAGE);
        this.setDirections(directions);
        this.setRandom(random);
    }

    @Override
    public String getTileName() {
        return "scorpion";
    }
}
