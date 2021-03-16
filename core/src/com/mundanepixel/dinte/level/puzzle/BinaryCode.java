package com.mundanepixel.dinte.level.puzzle;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.mundanepixel.dinte.ui.Text;

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
    public void tick() {

    }

    @Override
    public void render(Batch b) {

    }

    @Override
    public void onGUI(Batch b) {

    }
}
