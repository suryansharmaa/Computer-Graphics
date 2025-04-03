package Primitives;

import javax.swing.*;
import java.awt.*;

public class line extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);

        g.drawLine(50, 50, 300, 200);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Line Example");
        line panel = new line();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(panel);
        frame.setVisible(true);
    }
}
