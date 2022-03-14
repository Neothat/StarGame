package ru.geekbrains.stargame.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import ru.geekbrains.stargame.game.helpers.Poolable;
import ru.geekbrains.stargame.screen.ScreenManager;
import ru.geekbrains.stargame.screen.utils.Assets;

public class PowerUp implements Poolable {

    private enum Type {
        FIRST_AID_KIT,
        GOLD,
        AMMO;
    }

    private GameController gc;
    private TextureRegion texture;
    private Vector2 position;
    private Vector2 velocity;
    private Circle hitArea;
    private boolean active;
    private float angle;
    private float rotationSpeed;
    private Type type;

    @Override
    public boolean isActive() {
        return active;
    }

    public PowerUp(GameController gc) {
        this.gc = gc;
        this.position = new Vector2();
        this.velocity = new Vector2();
        this.hitArea = new Circle(0, 0, 0);
        this.active = false;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x - 16, position.y - 16, 16, 16,
                32, 32, 32, 32, angle);
    }

    public void update(float dt) {
        position.mulAdd(velocity, dt);
        angle += rotationSpeed * dt;

        if (position.x < -200) {
            position.x = ScreenManager.SCREEN_WIDTH + 200;
        }
        if (position.x > ScreenManager.SCREEN_WIDTH + 200) {
            position.x = -200;
        }
        if (position.y < -200) {
            position.y = ScreenManager.SCREEN_HEIGHT + 200;
        }
        if (position.y > ScreenManager.SCREEN_HEIGHT + 200) {
            position.y = -200;
        }
        hitArea.setPosition(position);
    }

    public void activate(float x, float y, float vx, float vy) {
        position.set(x, y);
        velocity.set(vx, vy);
        active = true;
        angle = MathUtils.random(0.0f, 360.0f);
        rotationSpeed = MathUtils.random(-180.0f, 180.0f);
        hitArea.setPosition(x, y);
        hitArea.setRadius(32 * 0.9f);
        type = Type.values()[MathUtils.random(2)];

        switch (type) {
            case FIRST_AID_KIT:
                this.texture = Assets.getInstance().getAtlas().findRegion("firstaidkit");
                break;
            case GOLD:
                this.texture = Assets.getInstance().getAtlas().findRegion("coin");
                break;
            case AMMO:
                this.texture = Assets.getInstance().getAtlas().findRegion("bullet");
                break;
            default:
                throw new RuntimeException("Unknown type");
        }
    }

    public void deactivate() {
        active = false;
    }
}
