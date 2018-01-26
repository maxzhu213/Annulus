import java.awt.*;
import java.util.ArrayList;

public class Level {

    public ArrayList<Block> blocks;

    public Level() {
        blocks = new ArrayList<>();
    }

    public void draw(Graphics g){
        for(int i = 0; i < blocks.size(); i++){
            g.setColor(blocks.get(i).color);
            g.fillRect(blocks.get(i).rect.x, blocks.get(i).rect.y, blocks.get(i).rect.width, blocks.get(i).rect.height);
        }
    }

}
