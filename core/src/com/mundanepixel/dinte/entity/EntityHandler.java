package com.mundanepixel.dinte.entity;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mundanepixel.dinte.level.Room;

import java.util.ArrayList;

public class EntityHandler {

    Room room;
    ArrayList<Entity> entities;

    public EntityHandler(Room room) {
        entities = new ArrayList<>();
        this.room = room;
    }

    public Entity addEntity(Entity e) {
        entities.add(e);
        return e;
    }

    public void removeEntity(Entity e) {
        entities.remove(e);
    }

    public void tick() {
        for(Entity e : entities) e.tick();
    }

    public void render(Batch b) {
        for(Entity e : entities) e.render(b);
    }

}
