package com.test.solar_system;

import com.badlogic.gdx.graphics.Texture;

public class Planet extends Body {

    public Planet(Texture texture, Float radius, Body mainBody, float distanceFromMainBody, float polarSpeed) {
        super(texture, radius, mainBody, distanceFromMainBody, polarSpeed);
    }

    public Planet(Texture texture, Float radius) {
        super(texture, radius);
    }
}
