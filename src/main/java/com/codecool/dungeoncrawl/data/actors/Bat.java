package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Bat extends Actor{
    private final static int baseHealth = 20;
    private final static int baseDamage = 1;
    public Bat(Cell cell) {
        super(cell, baseHealth, baseDamage);
    }

    @Override
    public void move() {
        super.move(1,0);
    }
    @Override
    public String getTileName() {
        return "bat";
    }
}
