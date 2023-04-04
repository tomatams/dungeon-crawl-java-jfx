package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Player extends Actor {
    private final static int baseHealth = 15;
    private final static int baseDamage = 5;
    public Player(Cell cell) {
        super(cell, baseHealth, baseDamage);

    }

    public String getTileName() {
        return "player";
    }
}
