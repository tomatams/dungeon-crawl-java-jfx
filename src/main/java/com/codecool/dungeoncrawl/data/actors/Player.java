package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.HashMap;
import java.util.Map;

public class Player extends Actor {

    private Map<String, Integer> itemList;
    private final static int BASE_HEALTH = 15;
    private final static int BASE_DAMAGE = 5;
    
    public Player(Cell cell) {
        super(cell, BASE_HEALTH, BASE_DAMAGE);
        itemList = new HashMap<>();
    }

    public String getTileName() {
        return "player";
    }

    @Override
    public void move(int dx, int dy) {
        onDoorCollide(dx, dy);
        super.move(dx, dy);
        if (getCell().getItem() != null){
            getCell().getItem().onPickUp();
        }
    }

    public void pickUpItem (Item item) {
        itemList.merge(item.toString(), 1, (a, b) ->a + b);
    }


    private void onDoorCollide(int dx, int dy) {
        Cell nextCell = super.getCell().getNeighbor(dx, dy);
        if (nextCell.getDoor() != null) {
            if (nextCell.getDoor().getTileName().equals("door-closed")) {
                if(itemList.containsKey("Key") && itemList.get("Key") >= 1) {
                    itemList.merge("Key", 1, (original, value) -> original - value);
                    nextCell.getDoor().open();
                }
            }
        }
    }

    public Map<String, Integer> getItemList() {
        return itemList;
    }
}
