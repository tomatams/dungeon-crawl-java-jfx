package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

import java.util.List;
import java.util.Random;

public class Skeleton extends Actor {
    private final static int baseHealth = 10;
    private final static int baseDamage = 2;
    private Random random = new Random();
    public Skeleton(Cell cell) {
        super(cell, baseHealth, baseDamage);
    }

    @Override
    public void move() {
        int direction = random.nextInt(5);
        switch (direction) {
            case 0:
                super.move(0,0);
                break;
            case 1:
                super.move(1,0);
                break;
            case 2:
                super.move(-1,0);
                break;
            case 3:
                super.move(0,1);
                break;
            case 4:
                super.move(0,-1);
                break;
        }

    }
    @Override
    public String getTileName() {
        return "skeleton";
    }
}
