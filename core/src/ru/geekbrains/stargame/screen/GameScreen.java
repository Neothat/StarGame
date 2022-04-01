package ru.geekbrains.stargame.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.geekbrains.stargame.game.GameController;
import ru.geekbrains.stargame.game.WorldRenderer;
import ru.geekbrains.stargame.screen.utils.Assets;

public class GameScreen extends AbstractScreen {

    private GameController gc;
    private WorldRenderer worldRenderer;

    public GameScreen(SpriteBatch batch) {
        super(batch);
    }

    @Override
    public void show() {
        Assets.getInstance().loadAssets(ScreenManager.ScreenType.GAME);
        this.gc = new GameController(batch);
        this.worldRenderer = new WorldRenderer(gc, batch);
    }

    @Override
    public void render(float delta) {
        gc.update(delta);
        worldRenderer.render();
    }

    public GameController getGc() {
        return gc;
    }
}
