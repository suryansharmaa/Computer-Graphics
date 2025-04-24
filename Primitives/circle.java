package Primitives;

import javax.swing.*;
import java.awt.*;

public class circle extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set the color to red
        g.setColor(Color.RED);

        g.fillOval(100, 100, 150, 150);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Example");
        circle panel = new circle();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(panel);
        frame.setVisible(true);
    }
}
