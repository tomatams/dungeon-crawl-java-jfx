package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Tiles {
    public static int TILE_WIDTH = 32;
    public static int DRAW_WIDTH = 64;

    private static Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private static Map<String, Tile> tileMap = new HashMap<>();
    public static class Tile {
        public final int x, y, w, h;
        Tile(int i, int j) {
            x = i * (TILE_WIDTH + 2);
            y = j * (TILE_WIDTH + 2);
            w = TILE_WIDTH;
            h = TILE_WIDTH;
        }
    }

    static {
        tileMap.put("empty", new Tile(0, 0));
        tileMap.put("wall", new Tile(10, 17));
        tileMap.put("floor", new Tile(2, 0));
        tileMap.put("player", new Tile(27, 0));
        tileMap.put("skeleton", new Tile(29, 6));
        tileMap.put("potion", new Tile(26, 23));
        tileMap.put("key", new Tile(16, 23));
        tileMap.put("scorpion", new Tile(24,5));
        tileMap.put("ghost",new Tile(26,6));
        tileMap.put("door-open", new Tile(8, 10));
        tileMap.put("door-closed", new Tile(8, 11));
        tileMap.put("stair", new Tile(1, 11));
        tileMap.put("grass",new Tile(6,0));
        tileMap.put("tree",new Tile(4,2));
    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y) {
        Tile tile = tileMap.get(d.getTileName());
        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                x * DRAW_WIDTH, y * DRAW_WIDTH, DRAW_WIDTH, DRAW_WIDTH);
    }
}
