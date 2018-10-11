package com.test.solar_system;

import com.badlogic.gdx.ScreenAdapter;

public class GameScreen extends ScreenAdapter {

    private SolarSystemGame game;

    private final float PLANET_RADIUS = 60f;
    private final float SUN_RADIUS = 90f;

    private final float PLANET1_FROM_SUN_DISTANCE = 200f;
    private final float PLANET2_FROM_SUN_DISTANCE = 150f;

    public static boolean IS_GAME_RUN = true;

    private Sun sun;
    private Planet planet1;
    private Planet planet2;

    GameScreen(SolarSystemGame game) {
        this.game = game;
        sun = new Sun(Assets.sun, SUN_RADIUS);
        planet1 = new Planet(Assets.planet1, PLANET_RADIUS, sun.position, PLANET1_FROM_SUN_DISTANCE);
        planet2 = new Planet(Assets.planet2, PLANET_RADIUS, sun.position, PLANET2_FROM_SUN_DISTANCE);
    }

    private void update(Float delta) {
        if (delta > 0.1f) delta = 0.1f;
        sun.update();
        planet1.update();
        planet2.update();
    }

    private void draw() {
        game.batch.begin();
        sun.render(game.batch);
        planet1.render(game.batch);
        planet2.render(game.batch);
        game.batch.end();
    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

}
