package com.test.solar_system;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Rectangle;

public class GameScreen extends ScreenAdapter {

    private SolarSystemGame game;

    private final float PLANET_RADIUS = 30f;
    public static final float SUN_RADIUS = 60f;
    private final float PLANET_1_SATELLITE_RADIUS = 5f;

    private final float PLANET1_FROM_SUN_DISTANCE = 200f;
    private final float PLANET1_SPEED = (float) Math.PI / 600;
    private final float PLANET1_SATELLITE_FROM_PLANET1_DISTANCE = 50f;
    private final float PLANET1_SATELLITE_SPEED = (float) Math.PI / 200;
    private final float PLANET2_FROM_SUN_DISTANCE = 125f;
    private final float PLANET2_SPEED = (float) Math.PI / 400;

    private final float BUTTON_SIZE = 100f;
    private final float BUTTON_MARGIN = 25f;

    public static boolean IS_GAME_RUN = true;

    private Sun sun;
    private Planet planet1;
    private Planet planet2;
    private Satellite planet1Satellite;

    private float deltaTime = 0f;

    private Rectangle buttonRect;

    GameScreen(SolarSystemGame game) {
        this.game = game;
        sun = new Sun(Assets.sun, SUN_RADIUS);
        planet1 = new Planet(Assets.planet1, PLANET_RADIUS, sun, PLANET1_FROM_SUN_DISTANCE, PLANET1_SPEED);
        planet2 = new Planet(Assets.planet2, PLANET_RADIUS, sun, PLANET2_FROM_SUN_DISTANCE, PLANET2_SPEED);
        planet1Satellite = new Satellite(Assets.planet1Satellite, PLANET_1_SATELLITE_RADIUS,
                planet1, PLANET1_SATELLITE_FROM_PLANET1_DISTANCE, PLANET1_SATELLITE_SPEED);
        buttonRect = new Rectangle(BUTTON_MARGIN, BUTTON_MARGIN, BUTTON_SIZE, BUTTON_SIZE);
        initButtonTouchDownListener();
    }

    private void update(Float delta) {
        deltaTime += delta;
        if (deltaTime >= 0.016f) {
            deltaTime = 0f;
            sun.update();
            planet1.update();
            planet2.update();
            planet1Satellite.update();
        }
    }

    private void draw() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        drawUI();
        sun.render(game.batch);
        planet1.render(game.batch);
        planet2.render(game.batch);
        planet1Satellite.render(game.batch);
        game.batch.end();
    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    private void drawUI() {
        game.batch.draw(Assets.background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.batch.draw(Assets.button, BUTTON_MARGIN, BUTTON_MARGIN, BUTTON_SIZE, BUTTON_SIZE);
    }

    private void initButtonTouchDownListener() {
        Gdx.input.setInputProcessor(new InputAdapter() {

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {

                screenY = Gdx.graphics.getHeight() - screenY; //strange stuff
                //i don't know why but screenX is inverted from top to bottom, but batcher bottom to top
                System.out.println(String.valueOf(screenX) + " " + String.valueOf(screenY));
                if (buttonRect.contains(screenX, screenY)) {
                    GameScreen.IS_GAME_RUN = !GameScreen.IS_GAME_RUN;
                }
                return true;
            }

        });
    }
}
