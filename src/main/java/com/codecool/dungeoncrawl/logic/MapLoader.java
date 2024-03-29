package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Ghost;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.Scorpion;
import com.codecool.dungeoncrawl.data.actors.Skeleton;
import com.codecool.dungeoncrawl.data.doors.Door;
import com.codecool.dungeoncrawl.data.items.Key;
import com.codecool.dungeoncrawl.data.items.Potion;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {

    public static GameMap loadMap(String level) {
        InputStream is = MapLoader.class.getResourceAsStream(level);
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            new Skeleton(cell);
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            break;
                        case 'H':
                            cell.setType(CellType.FLOOR);
                            new Potion("potion", cell);
                            break;
                        case 'K':
                            cell.setType(CellType.FLOOR);
                            new Key("Key", cell);
                            break;
                        case 'S':
                            cell.setType(CellType.FLOOR);
                            new Scorpion(cell);
                            break;
                        case 'b':
                            cell.setType(CellType.FLOOR);
                            new Ghost(cell);
                            break;
                        case 'D':
                            cell.setType(CellType.WALL);
                            map.addDoor(new Door(cell));
                            break;
                        case '%':
                            cell.setType(CellType.STAIR);
                            break;
                        case 't':
                            cell.setType(CellType.TREE);
                            break;
                        case ',':
                            cell.setType(CellType.GRASS);
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

}
