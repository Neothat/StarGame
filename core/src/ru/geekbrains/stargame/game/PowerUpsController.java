package ru.geekbrains.stargame.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import ru.geekbrains.stargame.game.helpers.ObjectPool;
import ru.geekbrains.stargame.screen.utils.Assets;

public class PowerUpsController extends ObjectPool<PowerUp> {
    private GameController gc;
    private TextureRegion[][] textures;

    @Override
    protected PowerUp newObject() {
        return new PowerUp(gc);
    }

    public PowerUpsController(GameController gc) {
        this.gc = gc;
        this.textures = new TextureRegion(Assets.getInstance().getAtlas().findRegion("powerups"))
                .split(32, 32);
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < activeList.size(); i++) {
            PowerUp p = activeList.get(i);
            int frameIndex = (int) (p.getTime() / 0.1f) % textures[p.getType().index].length;
            batch.draw(textures[p.getType().index][frameIndex], p.getPosition().x - 16, p.getPosition().y - 16);
        }
    }

    public void setup(float x, float y, float probability) {
        if (MathUtils.random() <= probability) {
            getActiveElement().activate(PowerUp.Type.values()[MathUtils.random(0, 2)], x, y, 30);
        }
    }

    public void update(float dt) {
        for (int i = 0; i < activeList.size(); i++) {
            activeList.get(i).update(dt);
        }
        checkPool();
    }
}
