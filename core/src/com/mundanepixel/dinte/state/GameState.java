package com.mundanepixel.dinte.state;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import com.mundanepixel.dinte.assets.Assets;
import com.mundanepixel.dinte.gfx.Renderer;
import com.mundanepixel.dinte.level.Room;
import com.mundanepixel.dinte.level.puzzle.BinaryCode;
import com.mundanepixel.dinte.level.puzzle.Puzzle;
import com.mundanepixel.dinte.level.puzzle.SimpleBinaryGuess;
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

        // Levels
        addRoom(new SimpleBinaryGuess());
        addRoom(new BinaryCode(0));

        // Reset
        level = 0;
        roomNum.message = "" + (level + 1);
        roomNum.centerContainerX(roomNumberContainer);
    }

    public static final Color tC = new Color(93 / 255f, 155 /255f, 121 / 255f, 1.0f);
    private void initUI() {
        roomNumberContainer = new Container(700, 118, 102, 70);
        roomNum = roomNumberContainer.addText(new Text("1032"));
        roomNum.centerContainerX(roomNumberContainer);
        roomNum.centerContainerY(roomNumberContainer);
        roomNum.setY(roomNum.yy - 12);
        roomNum.setColor(tC);


        clockContainer = new Container(700, 40, 102, 70);
        timerText = clockContainer.addText(new Text("30:00"));
        timerText.centerContainerX(clockContainer);
        timerText.centerContainerY(clockContainer);
        timerText.setColor(tC);

        dialogContainer = new Container(210, 60, 450, 100);
        dialogText = dialogContainer.addText(new Text(Assets.ROOM_DIALOG[level]));
        dialogText.setColor(tC);
    }

    public void addRoom(Puzzle puzzle) {
        level++;
        rooms.add(new Room(level, puzzle));
    }

    public void progress() {
        level++;
        roomNum.message = "" + (level + 1);
        roomNum.centerContainerX(roomNumberContainer);
    }

    @Override
    public void tick() {
        timer();
        if(rooms.size() != 0)
            rooms.get(level).tick();
    }

    final Color screenBlack = new Color(23 / 255f, 24 / 255f, 25 / 255f, 1);
    @Override
    public void render(Batch b) {
        b.draw(uiBase, 0,0, Renderer.DEFAULT_WIDTH, Renderer.DEFAULT_HEIGHT);
        if(rooms.size() != 0)
            rooms.get(level).render(b);
        b.setColor(screenBlack);
        b.draw(Assets.SIGNAL, 0, Renderer.DEFAULT_HEIGHT - 37, Renderer.DEFAULT_WIDTH, 40);
        b.setColor(Color.WHITE);
    }

    @Override
    public void onGUI(Batch b) {
        roomNumberContainer.render(b);
        clockContainer.render(b);
        dialogContainer.render(b);
        if(rooms.size() != 0)
            rooms.get(level).onGUI(b);
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
