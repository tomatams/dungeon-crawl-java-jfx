package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.HashMap;
import java.util.Map;

public class Player extends Actor {
    Map<String, Integer> itemList;
    public Player(Cell cell) {
        super(cell);
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

    public Map<String, Integer> getItemList() {
        return itemList;
    }
}
