package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {
    List<Item> itemList;
    public Player(Cell cell) {
        super(cell);
        itemList = new ArrayList<>();
    }

    public String getTileName() {
        return "player";
    }

    public void pickUpItem (Item item) {
        itemList.add(item);
    }
    public List<Item> getItemList() {
        return itemList;
    }
}
