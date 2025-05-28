import javax.swing.*;
import java.awt.*;

public class dda extends JPanel {
    int x1 = 50, y1 = 50;
    int x2 = 300, y2 = 200;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawDDALine(g, x1, y1, x2, y2);
    }

    public void drawDDALine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;

        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        float xIncrement = dx / (float) steps;
        float yIncrement = dy / (float) steps;

        float x = x1;
        float y = y1;

        for (int i = 0; i <= steps; i++) {
            g.drawLine(Math.round(x), Math.round(y), Math.round(x), Math.round(y)); // Draw point
            x += xIncrement;
            y += yIncrement;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DDA Line Drawing Algorithm");
        dda panel = new dda();

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
