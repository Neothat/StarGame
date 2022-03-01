package ru.geekbrains.stargame.game;

public class GameController {
    private Background background;
    private BulletController bulletController;
    private AsteroidController asteroidController;
    private Hero hero;

    public BulletController getBulletController() {
        return bulletController;
    }

    public Background getBackground() {
        return background;
    }

    public Hero getHero() {
        return hero;
    }

    public AsteroidController getAsteroidController() {
        return asteroidController;
    }

    public GameController() {
        this.background = new Background(this);
        this.bulletController = new BulletController();
        this.hero = new Hero(this);
        this.asteroidController = new AsteroidController();

    }

    public void update(float dt) {
        background.update(dt);
        bulletController.update(dt);
        hero.update(dt);
        asteroidController.update(dt);
        checkCollisions();
    }


    public void checkCollisions() {
        for (int i = 0; i < bulletController.getActiveList().size(); i++) {
            Bullet b = bulletController.getActiveList().get(i);

            if (hero.getPosition().dst(b.getPosition()) < 32.0f) {
                //b.deactivate();
            }
        }
    }
}
