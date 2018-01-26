import java.awt.*;

public class Walker extends Enemy {

    private final double gravAcc;

    public Walker(int health, int level, Rectangle model, Map map) {
        super(health, level, model, map);
        xVel = 0;
        yVel = 0;
        gravAcc = -.5;
    }

    @Override
    public void tick() {
        super.tick();

        model.y += yVel;
    }

    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(model.x, model.y, model.width, model.height);
    }
}
