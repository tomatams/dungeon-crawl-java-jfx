package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Arrays;
import java.util.List;

public class Up implements KeyHandler {
    public static final List<KeyCode> code = Arrays.asList(KeyCode.UP, KeyCode.W) ;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if (code.contains(event.getCode()))
            map.getPlayer().move(0, -1);
    }
}
