package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Potion extends Item{

    private int plusHealth = 20;

    public Potion(String name, Cell cell) {
        super(name, cell);
    }

    @Override
    public String getTileName() {
        return "potion";
    }

    public int getPlusHealth() {
        return plusHealth;
    }
}
