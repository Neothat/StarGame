package ru.geekbrains.stargame.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.geekbrains.stargame.game.helpers.ObjectPool;

public class UfoController extends ObjectPool<Ufo> {
    private GameController gc;

    @Override
    protected Ufo newObject() {
        return new Ufo(gc);
    }

    public UfoController(GameController gc) {
        this.gc = gc;
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < activeList.size(); i++) {
            Ufo u = activeList.get(i);
            u.render(batch);
        }
    }

    public void setup(float x, float y){
        getActiveElement().activate(x, y);
    }

    public void update(float dt) {
        for (int i = 0; i < activeList.size(); i++) {
            activeList.get(i).update(dt);
        }
        checkPool();
    }
}
