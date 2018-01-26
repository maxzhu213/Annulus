import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Map {

    private final int NUMBER_OF_LEVELS = 20;
    public int level = 0;

    public ArrayList<Level> levels;
    public ArrayList<Entity> entities;

    public Player player;

    public Map(){
        levels = new ArrayList<>();
        entities = new ArrayList<>();

        for(int i = 0; i < NUMBER_OF_LEVELS; i++){
            levels.add(new Level());
        }

        levels.get(0).blocks.add(new Block(new Rectangle(0, 1000, 2000, 100), Color.GREEN));
        levels.get(0).blocks.add(new Block(new Rectangle(1500, 800, 100, 600), Color.GREEN));
        levels.get(0).blocks.add(new Block(new Rectangle(0, -100, 10, 1200), Color.GREEN));

        levels.get(1).blocks.add(new Block(new Rectangle(0, 1000, 300, 100), Color.GREEN));
        levels.get(1).blocks.add(new Block(new Rectangle(600, 800, 20, 10), Color.GREEN));
        levels.get(1).blocks.add(new Block(new Rectangle(1200, 1000, 1000, 100), Color.GREEN));

        levels.get(2).blocks.add(new Block(new Rectangle(0, 1000, 50, 100), Color.GREEN));
        levels.get(2).blocks.add(new Block(new Rectangle(300, 800, 20, 10), Color.GREEN));
        levels.get(2).blocks.add(new Block(new Rectangle(600, 500, 20, 10), Color.GREEN));
        levels.get(2).blocks.add(new Block(new Rectangle(1000, 300, 20, 10), Color.GREEN));

        levels.get(12).blocks.add(new Block(new Rectangle(300, 300, 40, 40), Color.WHITE));
        levels.get(12).blocks.add(new Block(new Rectangle(900, 300, 40, 40), Color.WHITE));
        levels.get(12).blocks.add(new Block(new Rectangle(300, 600, 630, 40), Color.WHITE));

        levels.get(3).blocks.add(new Block(new Rectangle(0, 1000, 500, 100), Color.GREEN));
        levels.get(3).blocks.add(new Block(new Rectangle(500, 600, 20, 20), Color.GREEN));
        levels.get(3).blocks.add(new Block(new Rectangle(500, 200, 20, 20), Color.GREEN));
        levels.get(3).blocks.add(new Block(new Rectangle(1700, 1000, 500, 100), Color.GREEN));

        levels.get(13).blocks.add(new Block(new Rectangle(600, 1000, 1000, 20), Color.GREEN));

        levels.get(4).blocks.add(new Block(new Rectangle(0, 1000, 2000, 100), Color.GREEN));

        player = new Player(100, 100, this);

        entities.add(player);

        //entities.add(new Walker(10, 1, new Rectangle(600, 700, 40, 50), this));
    }
    public void tick(){
        for(int i = 0; i < entities.size(); i++){
            entities.get(i).tick();
        }
    }

    public void draw(Graphics g){
        levels.get(level).draw(g);
        for(int i = 0; i < entities.size(); i++){
            entities.get(i).draw(g);
        }
    }
}
