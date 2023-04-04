package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

import java.util.Random;

public class Scorpion extends Actor{
    private final static int baseHealth = 15;
    private final static int baseDamage = 2;
    private Random random = new Random();
    public Scorpion(Cell cell) {
        super(cell, baseHealth, baseDamage);
    }

    @Override
    public void move() {
        super.move(0,0);
    }

    @Override
    public String getTileName() {
        return "scorpion";
    }
}
