import java.awt.*;

public class Collisions {

    public static boolean checkDownCollision(Map map, Rectangle model, double yVel) {
        for (int i = 0; i < map.levels.get(map.level).blocks.size(); i++) {
            Rectangle temp = map.levels.get(map.level).blocks.get(i).rect;
            if (model.x + model.width > temp.x && model.x < temp.x + temp.width && model.y + model.height + yVel > temp.y && model.y + model.height < temp.y + temp.height) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkUpCollision(Map map, Rectangle model, double yVel) {
        for (int i = 0; i < map.levels.get(map.level).blocks.size(); i++) {
            Rectangle temp = map.levels.get(map.level).blocks.get(i).rect;
            if (model.x + model.width > temp.x && model.x < temp.x + temp.width && model.y > temp.y && model.y + yVel < temp.y + temp.height) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkLeftCollision(Map map, Rectangle model, double xVel, double xAcc) {
        for (int i = 0; i < map.levels.get(map.level).blocks.size(); i++) {
            Rectangle temp = map.levels.get(map.level).blocks.get(i).rect;
            if (model.x >= temp.x && model.x + xVel + xAcc < temp.x + temp.width && model.y + model.height > temp.y && model.y < temp.y + temp.height) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkRightCollision(Map map, Rectangle model, double xVel, double xAcc) {
        for (int i = 0; i < map.levels.get(map.level).blocks.size(); i++) {
            Rectangle temp = map.levels.get(map.level).blocks.get(i).rect;
            if (model.x + model.width + xVel + xAcc >= temp.x && model.x + model.width < temp.x + temp.width && model.y + model.height > temp.y && model.y < temp.y + temp.height) {
                return true;
            }
        }
        return false;
    }
}
