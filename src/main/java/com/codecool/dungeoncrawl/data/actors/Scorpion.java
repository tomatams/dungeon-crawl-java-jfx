package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Scorpion extends Actor{
    private final static int baseHealth = 15;
    private final static int baseDamage = 2;
    public Scorpion(Cell cell) {
        super(cell, baseHealth, baseDamage);
    }

    @Override
    public void move() {
        super.move(1,0);
    }

    @Override
    public String getTileName() {
        return "scorpion";
    }
}
