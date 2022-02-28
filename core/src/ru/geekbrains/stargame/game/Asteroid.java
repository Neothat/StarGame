package ru.geekbrains.stargame.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import ru.geekbrains.stargame.screen.ScreenManager;

public class Asteroid {

    private Texture textureAsteroid;
    private Vector2 position;
    private Vector2 velocity;
    private float angle;

    public Asteroid() {
        this.textureAsteroid = new Texture("asteroid.png");
        this.position = new Vector2(ScreenManager.SCREEN_WIDTH + 256, 360);
        this.velocity = new Vector2(0, 0);
        this.angle = 0.0f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(textureAsteroid, position.x - 128, position.y - 128, 128, 128,
                256, 256, 0.5f, 0.5f, angle, 0, 0, 256, 256,
                false, false);
    }

    public void update(float dt) {

    }
}
