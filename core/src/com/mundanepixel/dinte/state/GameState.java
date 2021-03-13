package com.mundanepixel.dinte.state;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mundanepixel.dinte.level.Room;
import com.mundanepixel.dinte.level.puzzle.BinaryCode;
import com.mundanepixel.dinte.level.puzzle.Puzzle;

import java.util.ArrayList;

public class GameState extends State {
    public static int level = 0;
    ArrayList<Room> rooms;

    public void init() {
        rooms = new ArrayList<>();
        addRoom(new BinaryCode(3));
    }

    public void addRoom(Puzzle puzzle) {
        level++;
        rooms.add(new Room(level, puzzle));
    }

    @Override
    public void tick() {
        rooms.get(level - 1).tick();
    }

    @Override
    public void render(Batch b) {
        rooms.get(level - 1).render(b);
    }

    @Override
    public void onGUI(Batch b) {
        rooms.get(level - 1).onGUI(b);
    }

    @Override
    public void dispose() {

    }
}
