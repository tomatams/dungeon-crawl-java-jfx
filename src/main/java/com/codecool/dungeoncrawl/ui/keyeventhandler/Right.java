package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Arrays;
import java.util.List;

public class Right implements KeyHandler {
    public static final List<KeyCode> code = Arrays.asList(KeyCode.RIGHT, KeyCode.D) ;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if (code.contains(event.getCode()))
            map.getPlayer().move(1, 0);
    }
}
