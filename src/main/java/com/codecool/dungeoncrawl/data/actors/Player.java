package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.HashMap;
import java.util.Map;

public class Player extends Actor {

    private Map<String, Integer> itemList;
    private final static int baseHealth = 15;
    private final static int baseDamage = 5;
    
    public Player(Cell cell) {
        super(cell, baseHealth, baseDamage);
        itemList = new HashMap<>();
    }

    public String getTileName() {
        return "player";
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
        if (getCell().getItem() != null){
            getCell().getItem().onPickUp();
        }
    }

    @Override
    public void pickUpItem (Item item) {
        itemList.merge(item.toString(), 1, (a, b) ->a + b);
    }

    public Map<String, Integer> getItemList() {
        return itemList;
    }
}
