package ru.geekbrains.stargame.game;

import com.badlogic.gdx.math.Vector2;
import ru.geekbrains.stargame.game.helpers.Poolable;

public class Asteroid implements Poolable {

    private Vector2 position;
    private Vector2 velocity;
    private boolean active;

    @Override
    public boolean isActive() {
        return active;
    }

    public Asteroid() {
        this.position = new Vector2();
        this.velocity = new Vector2();
        this.active = false;
    }

    public void update(float dt) {
        position.mulAdd(velocity, dt);

        if (position.x < -256) {
            deactivate();
        }
    }

    public void activate(float x, float y, float vx, float vy) {
        position.set(x, y);
        velocity.set(vx, vy);
        active = true;
    }

    public void deactivate() {
        active = false;
    }

    public Vector2 getPosition() {
        return position;
    }
}
