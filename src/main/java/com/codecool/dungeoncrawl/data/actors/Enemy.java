package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

import java.util.Random;

public abstract class Enemy extends Actor{
    int[][] directions;
    Random random;

    public void randomMove() {
        int[][] directions = {{1,0},{0,1},{0,-1},{-1,0},{0,0}};
        int[] randomDirection = directions[random.nextInt(directions.length)];
        super.move(randomDirection[0],randomDirection[1]);
    }

    public Enemy(Cell cell) {
        super(cell);
    }

}
