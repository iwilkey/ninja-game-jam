package com.mundanepixel.dinte.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mundanepixel.dinte.Settings;
import com.mundanepixel.dinte.assets.Assets;
import com.mundanepixel.dinte.gfx.Renderer;

import java.util.ArrayList;

public class Container extends UIObject {
    ArrayList<Container> containers;
    ArrayList<Text> texts;
    Color backgroundColor;
    TextureRegion backgroundTexture = null;

    // Construction
    public Container(int x, int y, int width, int height) {
        super(x, y, (int)(width * Settings.UI_SCALE), (int)(height * Settings.UI_SCALE));
        texts = new ArrayList<>();
        containers = new ArrayList<>();
        backgroundColor = new Color(1, 1, 1, 1);
    }

    // Physical attributes
    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }

    // Location
    public void setX(int x) {
        int diff = (int)DEFAULT_COLLIDER.x - x;
        DEFAULT_COLLIDER.x = x;
        for(Text t : texts) t.setX(t.xx - diff);
        for(Container c : containers) c.setX((int)c.DEFAULT_COLLIDER.x - diff);
    }

    public void setY(int y) {
        int diff = (int)DEFAULT_COLLIDER.y - y;
        DEFAULT_COLLIDER.y = y;
        for(Text t : texts) t.setY(t.yy - diff);
        for(Container c : containers) c.setY((int)c.DEFAULT_COLLIDER.y - diff);
    }

    // Dimensions
    public void setWidth(int width) {
        DEFAULT_COLLIDER.width = (int)(width * Settings.UI_SCALE);
    }

    public void setHeight(int height) {
        DEFAULT_COLLIDER.height = (int)(height * Settings.UI_SCALE);
    }

    public int centerScreenX() {
        setX((int)((Renderer.DEFAULT_WIDTH / 2) - (DEFAULT_COLLIDER.width / 2)));
        return (int)DEFAULT_COLLIDER.x;
    }

    public int centerScreenY() {
        setY((int)((Renderer.DEFAULT_HEIGHT / 2) - (DEFAULT_COLLIDER.height / 2)));
        return (int)DEFAULT_COLLIDER.y;
    }

    // Text methods
    public Text addText(Text text) {
        texts.add(text);
        this.setTextX(text, 0);
        this.setTextY(text, 0);
        return text;
    }

    public void removeText(Text text) {
        texts.remove(text);
    }

    public void setTextX(Text text, int xx) {
        for(Text t : texts)
            if(t == text)
                t.setX((int)DEFAULT_COLLIDER.x + (int)(xx * Settings.UI_SCALE));
    }

    public void setTextY(Text text, int yy) {
        for(Text t : texts)
            if(t == text)
                t.setY((int)(DEFAULT_COLLIDER.y + DEFAULT_COLLIDER.height) - (int)(yy * Settings.UI_SCALE));
    }

    public void centerTextX(Text text) {
        for(Text t : texts)
            if(t == text)
                t.centerContainerX(this);
    }

    public void centerTextY(Text text) {
        for(Text t : texts)
            if(t == text)
                t.centerContainerY(this);
    }

    // Container methods
    public Container addContainer(Container container) {
        containers.add(container);
        this.setContainerX(container, (int)container.DEFAULT_COLLIDER.x);
        this.setContainerY(container, (int)container.DEFAULT_COLLIDER.y - (int)container.DEFAULT_COLLIDER.height);
        return container;
    }

    public void removeContainer(Container container) {
        containers.remove(container);
    }

    public void setContainerX(Container container, int xx) {
        for(Container c : containers)
            if(c == container)
                c.setX((int)DEFAULT_COLLIDER.x +
                        (int)(xx * Settings.UI_SCALE));
    }

    public void setContainerY(Container container, int yy) {
        for(Container c : containers)
            if(c == container)
                c.setY((int)DEFAULT_COLLIDER.y +
                        (int)(yy * Settings.UI_SCALE));
    }

    // Local
    public int centerContainerX(Container c) {
        DEFAULT_COLLIDER.x = (int)(c.DEFAULT_COLLIDER.x +
                (c.DEFAULT_COLLIDER.width / 2)) - (DEFAULT_COLLIDER.width / 2);
        return (int)DEFAULT_COLLIDER.x;
    }

    public int centerContainerY(Container c) {
        DEFAULT_COLLIDER.y = (int)(c.DEFAULT_COLLIDER.y +
                (c.DEFAULT_COLLIDER.height / 2)) - (DEFAULT_COLLIDER.height / 2);
        return (int)DEFAULT_COLLIDER.y;
    }

    public void setBackgroundTexture(TextureRegion t) {
        this.backgroundTexture = t;
    }

    // Ticking
    @Override
    public void tick() {
        for(Container c : containers) c.tick();
    }

    // Rendering
    @Override
    public void render(Batch b) {
        if(backgroundTexture == null) {
            //b.setColor(backgroundColor);

            /*
            b.draw(Assets.SIGNAL, DEFAULT_COLLIDER.x,
                    DEFAULT_COLLIDER.y, DEFAULT_COLLIDER.width, DEFAULT_COLLIDER.height);
            */

            // b.setColor(Color.WHITE);
        } else b.draw(backgroundTexture, DEFAULT_COLLIDER.x,
                DEFAULT_COLLIDER.y, DEFAULT_COLLIDER.width, DEFAULT_COLLIDER.height);
        for(Container c : containers) c.render(b);
        for(Text t : texts)
            t.render(b, t.xx, t.yy);
    }
}
