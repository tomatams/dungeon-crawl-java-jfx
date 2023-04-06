package com.codecool.dungeoncrawl.data;

public enum CellType {
    EMPTY("empty",true),
    FLOOR("floor", true),
    WALL("wall", false),
    STAIR("stair", true),
    TREE("tree",false),
    GRASS("grass", true);


    private final String tileName;

    private final boolean isPassable;

    CellType(String tileName, boolean isPassable) {
        this.tileName = tileName;
        this.isPassable = isPassable;
    }

    public String getTileName() {
        return tileName;
    }

    public boolean isPassable() {
        return isPassable;
    }
}
