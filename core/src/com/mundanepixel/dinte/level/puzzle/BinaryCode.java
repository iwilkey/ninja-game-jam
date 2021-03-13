package com.mundanepixel.dinte.level.puzzle;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.mundanepixel.dinte.ui.Text;

public class BinaryCode extends Puzzle {

    Text text;
    int length;
    int[] answer;

    public BinaryCode(int length) {
        this.length = length;
        this.answer = new int[length];
        for(int i = 0; i < length; i++)
            answer[i] = MathUtils.random(0, 1);

        text = new Text("");
        text.setSize(43);
        for(int i = 0; i < length; i++) {
            text.message += answer[i] + " ";
        }
        text.centerScreenY();
        text.centerScreenX();
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Batch b) {

    }

    @Override
    public void onGUI(Batch b) {
        text.render(b);
    }
}
