package ru.geekbrains.stargame.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.geekbrains.stargame.screen.utils.Assets;

public class WorldRenderer {
    private GameController gc;
    private SpriteBatch batch;
    private BitmapFont font32;

    public WorldRenderer(GameController gc, SpriteBatch batch) {
        this.gc = gc;
        this.batch = batch;
        this.font32 = Assets.getInstance().getAssetManager().get("fonts/font32.ttf", BitmapFont.class);
    }

    public void render() {
        ScreenUtils.clear(0, 0, 0.5f, 1);
        batch.begin();
        gc.getBackground().render(batch);
        gc.getBulletController().render(batch);
        gc.getHero().render(batch);
        gc.getAsteroidController().render(batch);
        gc.getPowerUpController().render(batch);
        gc.getParticleController().render(batch);
        gc.getHero().render(batch);
        gc.getHero().renderGUI(batch, font32);
        batch.end();
    }
}
