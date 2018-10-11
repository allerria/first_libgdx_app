package com.test.solar_system;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Sun extends Body {

    Sun(Texture texture, Float radius) {
        super(texture, radius);
        this.position.x = Gdx.graphics.getWidth() / 2 - radius;
        this.position.y = Gdx.graphics.getHeight() / 2 - radius;
    }

    public Vector2 getPosition() {
        return position;
    }
}
