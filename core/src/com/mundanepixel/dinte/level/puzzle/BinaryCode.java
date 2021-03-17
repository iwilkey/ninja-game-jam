package com.mundanepixel.dinte.level.puzzle;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;

import com.mundanepixel.dinte.entity.EntityHandler;
import com.mundanepixel.dinte.entity.Screen;
import com.mundanepixel.dinte.ui.Text;

// Level 2
public class BinaryCode extends Puzzle {

    int length;
    int[] answer;

    public BinaryCode(int length) {
        this.length = length;
        this.answer = new int[length];
        for(int i = 0; i < length; i++)
            answer[i] = MathUtils.random(0, 1);
    }

    @Override
    public void init(EntityHandler handler) {
        Screen screen = (Screen) handler.addEntity(new Screen(500, 350, 5, 4));
        Text t = screen.addText(new Text("You can put text\non this screen! \nHow about that!"));
        t.setSize(10);
        t.centerContainerX(screen.screenContainer);
        t.centerContainerY(screen.screenContainer);

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Batch b) {

    }

    @Override
    public void onGUI(Batch b) {

    }
}
