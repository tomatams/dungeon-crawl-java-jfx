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
    public void pickUpItem (Item item) {
        //itemList.put(item, itemList.getOrDefault(item, 0) + 1);
        itemList.merge(item.toString(), 1, (a, b) ->a + b);
    }

    @Override
    public void move(int dx, int dy) {
        onDoorCollide(dx, dy);
        super.move(dx, dy);
    }

    private void onDoorCollide(int dx, int dy) {
        Cell nextCell = super.getCell().getNeighbor(dx, dy);
        if (nextCell.getDoor() != null) {
            if (nextCell.getDoor().getTileName().equals("door-closed")) {
                if(itemList.containsKey("Key") && itemList.get("Key") >= 1) {
                    itemList.merge("Key", 1, (original, value) -> original - value);
                    super.getCell().getGameMap().getDoor().open();
                }
            }
        }
    }

    public Map<String, Integer> getItemList() {
        return itemList;
    }
}
