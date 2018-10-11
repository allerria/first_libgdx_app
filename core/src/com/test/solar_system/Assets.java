package com.test.solar_system;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
    public static Texture background;

    public static Texture sun;

    public static Texture planet1;

    public static Texture planet2;
    public static Texture planet2Satellite;

    public static Texture loadTexture(String file) {
        return new Texture(file);
    }

    public static void load() {
        background = loadTexture("background.png");
        sun = loadTexture("sun.png");
        planet1 = loadTexture("planet1.png");
        planet2 = loadTexture("planet2.png");
        planet2Satellite = loadTexture("planet2_satellite.png");
    }

    public static void dispose() {
        background.dispose();
        sun.dispose();
        planet1.dispose();
        planet2.dispose();
        planet2Satellite.dispose();
    }

}
