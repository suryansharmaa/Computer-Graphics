package Primitives;

import javax.swing.*;
import java.awt.*;

public class rectangle extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);

        g.fillRect(50, 50, 200, 100); // x = 50, y = 50, width = 200, height = 100
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rectangle Example");
        rectangle panel = new rectangle();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(panel);
        frame.setVisible(true);
    }
}
