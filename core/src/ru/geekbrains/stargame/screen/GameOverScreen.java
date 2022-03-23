package ru.geekbrains.stargame.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameOverScreen extends MenuScreen {

    public GameOverScreen(SpriteBatch batch) {
        super(batch);
    }

    @Override
    public void render(float delta) {
        update(delta);
        ScreenUtils.clear(0.0f, 0.0f, 0.05f, 1);
        batch.begin();
        font72.draw(batch, "Game Over", 0, 600, 1280, 1, false);
        font24.draw(batch, "Score: " + ScreenManager.getInstance().getGameScreen().getGc().getHero().getScore(),
                0, 450, 1280, 1, false);
        font24.draw(batch, "Money: " + ScreenManager.getInstance().getGameScreen().getGc().getHero().getMoney(),
                0, 400, 1280, 1, false);
        batch.end();
        stage.draw();
    }
}
