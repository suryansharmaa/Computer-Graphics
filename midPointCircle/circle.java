package midPointCircle;

import java.awt.*;
import javax.swing.*;

public class circle extends JPanel {

    private int centerX;
    private int centerY;
    private int radius1;
    private int radius2;

    public circle(int width, int height, int r1, int r2) {
        setPreferredSize(new Dimension(width, height));
        centerX = width / 2;
        centerY = height / 2;
        radius1 = Math.min(r1, r2); // Ensure radius1 is smaller
        radius2 = Math.max(r1, r2); // Ensure radius2 is larger
    }

    private void drawCircle(Graphics g, int radius) {
        int x = 0;
        int y = radius;
        int decisionParameter = 1 - radius;

        while (x <= y) {
            g.fillRect(centerX + x, centerY + y, 1, 1);
            g.fillRect(centerX - x, centerY + y, 1, 1);
            g.fillRect(centerX + x, centerY - y, 1, 1);
            g.fillRect(centerX - x, centerY - y, 1, 1);
            g.fillRect(centerX + y, centerY + x, 1, 1);
            g.fillRect(centerX - y, centerY + x, 1, 1);
            g.fillRect(centerX + y, centerY - x, 1, 1);
            g.fillRect(centerX - y, centerY - x, 1, 1);

            if (decisionParameter < 0) {
                decisionParameter += 2 * x + 3;
            } else {
                decisionParameter += 2 * (x - y) + 5;
                y--;
            }
            x++;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE); // Color for the inner circle
        drawCircle(g, radius1);
        g.setColor(Color.RED); // Color for the outer circle
        drawCircle(g, radius2);
    }

    public static void main(String[] args) {
        int width = 400;
        int height = 400;
        int innerRadius = 80;
        int outerRadius = 150;

        JFrame frame = new JFrame("Concentric Circles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        circle circles = new circle(width, height, innerRadius, outerRadius);
        frame.add(circles);
        frame.pack();
        frame.setVisible(true);
    }
}
