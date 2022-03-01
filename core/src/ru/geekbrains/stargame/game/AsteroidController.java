package ru.geekbrains.stargame.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.geekbrains.stargame.game.helpers.ObjectPool;

public class AsteroidController extends ObjectPool<Asteroid> {
    private Texture asteroidTexture;

    @Override
    protected Asteroid newObject() {
        return new Asteroid();
    }

    public AsteroidController() {
        this.asteroidTexture = new Texture("asteroid.png");
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < activeList.size(); i++) {
            Asteroid a = activeList.get(i);
            batch.draw(asteroidTexture, a.getPosition().x - 128, a.getPosition().y - 128, 128, 128,
                256, 256, 0.5f, 0.5f, 0, 0, 0, 256, 256,
                false, false);
        }
    }

    public void setup(float x, float y, float vx, float vy) {
        getActiveElement().activate(x, y, vx, vy);
    }

    public void update(float dt) {
        for (int i = 0; i < activeList.size(); i++) {
            activeList.get(i).update(dt);
        }
        checkPool();
    }
}
