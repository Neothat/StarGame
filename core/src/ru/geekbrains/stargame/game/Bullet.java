package ru.geekbrains.stargame.game;

import com.badlogic.gdx.math.Vector2;
import ru.geekbrains.stargame.game.helpers.Poolable;
import ru.geekbrains.stargame.screen.ScreenManager;

public class Bullet implements Poolable {
    private GameController gc;
    private Vector2 position;
    private Vector2 velocity;
    private boolean active;
    private Ship owner;

    @Override
    public boolean isActive() {
        return active;
    }

    public Bullet(GameController gc) {
        this.gc = gc;
        this.position = new Vector2();
        this.velocity = new Vector2();
        this.active = false;
    }

    public void deactivate() {
        active = false;
    }

    public void update(float dt) {
        position.mulAdd(velocity, dt);
        if (position.x < -20 || position.x > ScreenManager.SCREEN_WIDTH + 20 ||
                position.y < -20 || position.y > ScreenManager.SCREEN_HEIGHT + 20) {
            deactivate();
        }

        gc.getParticleController().getEffectBuilder().createBulletTrace(this);
    }

    public void activate(Ship owner, float x, float y, float vx, float vy) {
        this.owner = owner;
        position.set(x, y);
        velocity.set(vx, vy);
        active = true;
    }

    public Ship getOwner() {
        return owner;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }
}
