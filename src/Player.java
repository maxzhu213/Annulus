import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Collections;

public class Player extends Entity {

    private final double maxVel = 10;
    private final double acc = 1;
    private final double gravAcc = .5;
    private final int jumpHeight = 20;

    private boolean[] keys = new boolean[1000];

    private Color color = Color.BLACK;

    public Player(int x, int y, Map map) {
        super(map);
        this.model = new Rectangle(x, y, 50, 100);
        xVel = 0;
        yVel = 0;
        xAcc = 0;
        yAcc = gravAcc;

    }

    public void mousePress(MouseEvent e) {

    }

    public void mouseRelease(MouseEvent e) {

    }

    public void keyPress(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    public void keyRelease(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public void tick() {
        super.tick();

        if (Math.abs(xVel) < maxVel) {
            xVel += xAcc;
        }
        if (xAcc == 0) {
            xVel -= Math.signum(xVel) * acc;
        }

        if (keys[KeyEvent.VK_D]) {
            xAcc = acc;
        } else if (keys[KeyEvent.VK_A]) {
            xAcc = -acc;
        } else {
            xAcc = 0;
        }

        if (keys[KeyEvent.VK_SPACE] && touchDown && !touchUp) {
            yVel = -jumpHeight;
        }

        model.x += xVel;

        if ((!touchDown && yVel > 0) || (!touchUp && yVel < 0)) {
            model.y += yVel;
        }
        if (touchUp) {
            yVel = 0;
        }

        if(model.x > 1920){
            map.level++;
            model.x = 0;
            model.y -= 5;
        }
        if(model.x < -model.width){
            map.level--;
            model.x = 1920;
            model.y -= 5;
        }
        if(model.y < 0){
            map.level += 10;
            model.y = 1000;
        }
        if(model.y > 1200){
            map.level -= 10;
            model.y = 0;

            if (map.level < 0){
                map.level = 0;
                model.x = 100;
                model.y = 100;
            }
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(model.x, model.y, model.width, model.height);
    }

    public double getxVel() {
        return xVel;
    }

    public double getyVel() {
        return yVel;
    }

    public double getxAcc() {
        return xAcc;
    }

    public double getyAcc() {
        return yAcc;
    }

    public void setxVel(double xVel) {
        this.xVel = xVel;
    }

    public void setyVel(double yVel) {
        this.yVel = yVel;
    }

    public void setxAcc(double xAcc) {
        this.xAcc = xAcc;
    }

    public void setyAcc(double yAcc) {
        this.yAcc = yAcc;
    }
}
