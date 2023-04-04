package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Skeleton extends Actor {
    private final static int baseHealth = 10;
    private final static int baseDamage = 2;
    public Skeleton(Cell cell) {
        super(cell, baseHealth, baseDamage);
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }
}
