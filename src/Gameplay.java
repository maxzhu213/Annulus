import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gameplay extends JPanel implements KeyListener, ActionListener, MouseListener {

    private int delay = 10;

    Timer timer;
    Map map;

    public Gameplay(){
        map = new Map();

        timer = new Timer(delay, this);
        timer.start();

        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

        addKeyListener(this);
        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 1920, 1080);

        map.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        map.tick();

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        map.player.keyPress(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        map.player.keyRelease(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        map.player.mousePress(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        map.player.mouseRelease(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
