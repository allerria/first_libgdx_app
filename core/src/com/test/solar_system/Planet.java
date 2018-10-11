package com.test.solar_system;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Planet extends Body {

    public Planet(Texture texture, Float radius, Body mainBody, float distanceFromMainBody, float polarSpeed) {
        super(texture, radius, mainBody, distanceFromMainBody, polarSpeed);
    }

    public Planet(Texture texture, Float radius) {
        super(texture, radius);
    }
}
