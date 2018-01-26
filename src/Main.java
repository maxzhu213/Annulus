import javax.swing.*;

public class Main {

    JFrame frame;
    Gameplay gameplay;

    Main(){
        gameplay = new Gameplay();

        frame = new JFrame("Basic Platformer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);
        frame.add(gameplay);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        Main main = new Main();
    }

}
