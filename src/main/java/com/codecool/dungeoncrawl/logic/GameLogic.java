package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Enemy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameLogic {

    private List<GameMap> map;

    public static void nextLevel() {
        GameLogic.currentLevel++;
    }

    private static Integer currentLevel = 0;

    public GameLogic() {
        map = new ArrayList<GameMap>();
        List<String> listOfLevels = Stream.of(new File("src/main/resources/levels").listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toList());
        for (final String fileEntry : listOfLevels) {
            this.map.add(MapLoader.loadMap("/levels/" + fileEntry));
        }
    }

    public int getMapWidth() {
        return map.get(currentLevel).getWidth();
    }

    public int getMapHeight() {
        return map.get(currentLevel).getHeight();
    }

    public void setup() {
    }

    public Cell getCell(int x, int y) {
        return map.get(currentLevel).getCell(x, y);
    }

    public Cell getPlayerCell() {
        return map.get(currentLevel).getPlayer().getCell();
    }

    public String getPlayerHealth() {
        return Integer.toString(map.get(currentLevel).getPlayer().getHealth());
    }
    public String getPlayersInventory (){
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> set :
                map.get(currentLevel).getPlayer().getItemList().entrySet()) {
            stringBuilder.append(set.getKey() + " : " + set.getValue() + " ");
        }
        return stringBuilder.toString();
    }

    public GameMap getMap() {
        return map.get(currentLevel);
    }

    public GameMap getMap(int i) {
        return map.get(i);
    }

    public void moveAllEnemies() {
        List<Enemy> enemies = map.get(currentLevel).getAllEnemies();
        for (Enemy enemy: enemies) {
            enemy.randomMove();
        }
    }
}
