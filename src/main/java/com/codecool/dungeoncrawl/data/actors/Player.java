package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.HashMap;
import java.util.Map;

public class Player extends Actor {

    private String playerName;

    private Map<String, Integer> itemList;
    private final static int BASE_HEALTH = 15;
    private final static int BASE_DAMAGE = 5;
    
    public Player(String playerName, Cell cell) {
        super(cell, BASE_HEALTH, BASE_DAMAGE);
        itemList = new HashMap<>();
        this.playerName = playerName;
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

    public void pickUpItem (Item item) {
        itemList.merge(item.toString(), 1, (a, b) ->a + b);
    }

    public Map<String, Integer> getItemList() {
        return itemList;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
