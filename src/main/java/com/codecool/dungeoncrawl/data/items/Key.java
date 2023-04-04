package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Key extends Item{

    public Key(String name, Cell cell) {
        super(name, cell);
    }

    @Override
    public String getTileName() {
        return "key";
    }
}
