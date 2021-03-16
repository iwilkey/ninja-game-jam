package com.mundanepixel.dinte.state;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import com.mundanepixel.dinte.assets.Assets;
import com.mundanepixel.dinte.gfx.Renderer;
import com.mundanepixel.dinte.level.Room;
import com.mundanepixel.dinte.level.puzzle.BinaryCode;
import com.mundanepixel.dinte.level.puzzle.Puzzle;
import com.mundanepixel.dinte.ui.Container;
import com.mundanepixel.dinte.ui.Text;

import java.util.ArrayList;

public class GameState extends State {

    public static int level = 0;
    public static long timer = 1800; // In seconds.
    ArrayList<Room> rooms;

    Texture uiBase;
    Container roomNumberContainer,
        clockContainer,
        dialogContainer;
    Text roomNum, timerText, dialogText;

    public void init() {
        uiBase = Assets.UI_BASE;
        initUI();
        rooms = new ArrayList<>();
        addRoom(new BinaryCode(0));
    }

    private void initUI() {
        roomNumberContainer = new Container(700, 118, 102, 70);
        roomNum = roomNumberContainer.addText(new Text("1032"));
        roomNum.centerContainerX(roomNumberContainer);
        roomNum.centerContainerY(roomNumberContainer);
        roomNum.setY(roomNum.yy - 12);

        clockContainer = new Container(700, 40, 102, 70);
        timerText = clockContainer.addText(new Text("30:00"));
        timerText.centerContainerX(clockContainer);
        timerText.centerContainerY(clockContainer);

        dialogContainer = new Container(210, 60, 450, 100);
        dialogText = dialogContainer.addText(new Text("Can you solve my code?"));
    }

    public void addRoom(Puzzle puzzle) {
        level++;
        rooms.add(new Room(level, puzzle));
    }

    @Override
    public void tick() {
        timer();
        if(rooms.size() != 0)
            rooms.get(level - 1).tick();
    }

    @Override
    public void render(Batch b) {
        b.draw(uiBase, 0,0, Renderer.DEFAULT_WIDTH, Renderer.DEFAULT_HEIGHT);
        if(rooms.size() != 0)
            rooms.get(level - 1).render(b);
    }

    @Override
    public void onGUI(Batch b) {
        roomNumberContainer.render(b);
        clockContainer.render(b);
        dialogContainer.render(b);
        if(rooms.size() != 0)
            rooms.get(level - 1).onGUI(b);
    }

    long then, now = System.nanoTime(),
        delta;
    byte min, sec;
    String display;
    private void timer() {
        then = now;
        now = System.nanoTime();
        delta += (now - then);
        if(delta > 1000000000) {
            timer--;
            delta = 0;

            // Update display
            min = (byte)(timer / 60.0f);
            sec = (byte)(timer % 60);
            if(min < 10 && sec < 10)
                display = "0" + min + ":" + "0" + sec;
            else if (min >= 10 && sec < 10)
                display = min + ":" + "0" + sec;
            else if (min < 10)
                display = "0" + min + ":" + sec;
            else display = min + ":" + sec;
            timerText.message = display;
            timerText.centerContainerX(clockContainer);
        }
    }

    @Override
    public void dispose() {}
}
