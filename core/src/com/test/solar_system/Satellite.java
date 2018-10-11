package com.test.solar_system;

import com.badlogic.gdx.graphics.Texture;

public class Satellite extends Body {
    Satellite(Texture texture, Float radius, Body mainBody, float distanceFromMainBody, float polarSpeed) {
        super(texture, radius, mainBody, distanceFromMainBody, polarSpeed);
    }

    Satellite(Texture texture, Float radius) {
        super(texture, radius);
    }
}
