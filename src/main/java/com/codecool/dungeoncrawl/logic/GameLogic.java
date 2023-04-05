package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;

import java.util.Map;
import java.util.Scanner;

public class GameLogic {
    private GameMap map;

    public GameLogic() {
        this.map = MapLoader.loadMap();
    }

    public double getMapWidth() {
        return map.getWidth();
    }

    public double getMapHeight() {
        return map.getHeight();
    }

    public void setup() {
    }

    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }

    public String getPlayerHealth() {
        return Integer.toString(map.getPlayer().getHealth());
    }
    public String getPlayersInventory (){
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> set :
                map.getPlayer().getItemList().entrySet()) {
            stringBuilder.append(set.getKey() + " : " + set.getValue() + " ");
        }
        return stringBuilder.toString();
    }

    public GameMap getMap() {
        return map;
    }
}
