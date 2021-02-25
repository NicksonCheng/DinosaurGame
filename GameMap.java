import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameMap extends JFrame implements KeyListener {
    private Timer dinaTimer = new Timer();
    private Timer roadTimer = new Timer();

    private JLabel dinaLabel = new JLabel(new ImageIcon("./img/1.png"));
    private JLabel road1 = new JLabel(new ImageIcon("./img/road.png"));
    private JLabel road2 = new JLabel(new ImageIcon("./img/road.png"));
    private ImageIcon dinaImg;
    private int dinaCount = 1;
    private int road_y = 400;
    private int range_x = 1500;
    private int range_y = 800;

    GameMap() {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

        System.out.println(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        System.out.println(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    public void InitMap() {

        this.setSize(range_x, range_y);
        this.setVisible(true);
        this.setLayout(null);
        dinaLabel.setSize(120, 100);
        dinaLabel.setLocation(100, 300);
        dinaTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (dinaCount > 3)
                    dinaCount = 1;
                dinaImg = new ImageIcon("./img/" + dinaCount + ".png");
                dinaLabel.setIcon(dinaImg);
                ++dinaCount;
            }
        }, 0, 100);

        this.add(dinaLabel);
        road1.setSize(range_x, 30);
        road1.setLocation(0, road_y);
        road2.setSize(range_x, 30);
        road2.setLocation(range_x, road_y);
        roadTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                // TODO Auto-generated method stub

                if (road1.getLocation().getX() < road2.getLocation().getX()) {
                    int road_x = (int) road1.getLocation().getX() - 50;
                    road1.setLocation(road_x, road_y);
                    road2.setLocation(road_x + range_x, road_y);
                } else {
                    int road_x = (int) road2.getLocation().getX() - 50;
                    road2.setLocation(road_x, road_y);
                    road1.setLocation(road_x + range_x, road_y);
                }
                if (road1.getLocation().getX() + range_x <= 0)
                    road1.setLocation(range_x, road_y);
                else if (road2.getLocation().getX() + range_x <= 0)
                    road2.setLocation(range_x, road_y);

            }
        }, 0, 100);
        this.add(road1);
        this.add(road2);
    }
}
