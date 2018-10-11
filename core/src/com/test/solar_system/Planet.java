package com.test.solar_system;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Planet extends Body {

    Planet(Texture texture, Float radius, Vector2 sunPosition, Float distanceFromSun) {
        super(texture, radius);
        this.sunPosition = sunPosition;
        this.distanceFromSun = distanceFromSun;
    }

    private Vector2 sunPosition;
    private float angle = 0f;
    private float distanceFromSun = 0f;

    @Override
    public void update() {
        super.update();
        if (GameScreen.IS_GAME_RUN) {
            angle += 2 * Math.PI / 60; // 1 minute - 1 turn
        }
        position = newPosition();
    }

    private Vector2 newPosition() {
        return sunPosition.add(distanceFromSun * (float) Math.cos(angle), distanceFromSun * (float) Math.sin(angle));
    }
}
