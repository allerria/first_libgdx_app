package com.test.solar_system;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Sun extends Body {

    public Sun(Texture texture, Float radius) {
        super(texture, radius);
        this.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);

    }

    public Sun(Texture texture, Float radius, Body mainBody, float distanceFromMainBody, float polarSpeed) {
        super(texture, radius, mainBody, distanceFromMainBody, polarSpeed);
    }
}
