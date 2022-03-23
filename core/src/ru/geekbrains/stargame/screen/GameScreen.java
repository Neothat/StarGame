package ru.geekbrains.stargame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.geekbrains.stargame.game.GameController;
import ru.geekbrains.stargame.game.WorldRenderer;
import ru.geekbrains.stargame.screen.utils.Assets;

public class GameScreen extends AbstractScreen {

    private GameController gc;
    private WorldRenderer worldRenderer;
    private boolean pauseActivated;

    public GameScreen(SpriteBatch batch) {
        super(batch);
    }

    public boolean isPauseActivated() {
        return pauseActivated;
    }

    public void setPauseActivated(boolean pauseActivated) {
        this.pauseActivated = pauseActivated;
    }

    public GameController getGc() {
        return gc;
    }

    @Override
    public void show() {
        Assets.getInstance().loadAssets(ScreenManager.ScreenType.GAME);
        this.gc = new GameController();
        this.worldRenderer = new WorldRenderer(gc, batch);
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            setPauseActivated(!pauseActivated);
        }
        gc.update(delta);
        worldRenderer.render();
    }
}
