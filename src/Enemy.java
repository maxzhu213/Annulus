import java.awt.*;

public class Enemy extends Entity{

    protected boolean alive;
    protected int health;
    protected int level;

    public Enemy(int health, int level, Rectangle model, Map map) {
        super(map);
        this.health = health;
        this.level = level;
        this.model = model;
        alive = true;
    }

    @Override
    public void tick() {
        super.tick();
    }
}
