package com.test.solar_system;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Body {

    Body(Texture texture, Float radius) {
        this.texture = texture;
        this.radius = radius;
    }

    private Texture texture;
    private Float radius;

    protected Vector2 position = new Vector2();

    public void update() {
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, radius * 2, radius * 2);
    }
}
