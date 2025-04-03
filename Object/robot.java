package Object;

import javax.swing.*;
import java.awt.*;

public class robot extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Robot Head
        g2d.setColor(Color.GRAY);
        g2d.fillRect(150, 50, 100, 100);

        // Robot Eyes
        g2d.setColor(Color.CYAN);
        g2d.fillRect(170, 70, 20, 20);
        g2d.fillRect(210, 70, 20, 20);

        // Robot Mouth
        g2d.setColor(Color.RED);
        g2d.fillRect(180, 120, 40, 10);

        // Robot Body
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(125, 150, 150, 200);

        // Robot Arms
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(75, 175, 50, 100);
        g2d.fillRect(275, 175, 50, 100);

        // Robot Legs
        g2d.setColor(Color.GRAY);
        g2d.fillRect(150, 350, 50, 100);
        g2d.fillRect(200, 350, 50, 100);

        // Antenna
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(195, 20, 10, 30);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Robot");
        robot panel = new robot();
        panel.setPreferredSize(new Dimension(400, 500));
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
