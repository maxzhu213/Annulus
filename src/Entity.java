import java.awt.*;

public class Entity {

    protected double xVel;
    protected double yVel;
    protected double xAcc;
    protected double yAcc;

    protected boolean touchUp = false, touchDown = false, touchLeft = false, touchRight = false;

    protected Rectangle model;

    protected Map map;

    public Entity(){
        this.map = new Map();
    }

    public Entity(Map map){
        this.map = map;
    }

    public void tick(){
        if (Collisions.checkDownCollision(map, model, yVel)) {
            touchDown = true;
            yVel = 0;
        } else {
            touchDown = false;
            yVel += yAcc;
        }

        if (Collisions.checkUpCollision(map, model, yVel)) {
            touchUp = true;
            model.y -= yVel;
            yVel = 0;
        } else {
            touchUp = false;
        }

        if(Collisions.checkLeftCollision(map, model, xVel, xAcc)){
            touchLeft = true;
            model.x -= xVel;
            xVel = 0;
        } else {
            touchLeft = false;
        }

        if(Collisions.checkRightCollision(map, model, xVel, xAcc)){
            touchRight = true;
            model.x -= xVel;
            xVel = 0;
        } else {
            touchRight = false;
        }
    }
    public void draw(Graphics g){}
}
