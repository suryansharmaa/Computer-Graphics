package fourFigures;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

public class shapes extends JPanel {

    private int screenWidth = 800;
    private int screenHeight = 600;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int regionWidth = screenWidth / 2;
        int regionHeight = screenHeight / 2;

        g2d.drawLine(regionWidth, 0, regionWidth, screenHeight);
        g2d.drawLine(0, regionHeight, screenWidth, regionHeight);

        // Circle
        g2d.setColor(Color.RED);
        int circleRadius = Math.min(regionWidth, regionHeight) / 4;
        int circleX = regionWidth / 2 - circleRadius;
        int circleY = regionHeight / 2 - circleRadius;
        g2d.fillOval(circleX, circleY, 2 * circleRadius, 2 * circleRadius);

        // Rectangle
        g2d.setColor(Color.GREEN);
        int rectWidth = regionWidth / 3;
        int rectHeight = regionHeight / 3;
        int rectX = regionWidth + (regionWidth - rectWidth) / 2;
        int rectY = (regionHeight - rectHeight) / 2;
        g2d.fillRect(rectX, rectY, rectWidth, rectHeight);

        // Arc
        g2d.setColor(Color.BLUE);
        int arcRadius = Math.min(regionWidth, regionHeight) / 3;
        int arcX = regionWidth / 2 - arcRadius;
        int arcY = regionHeight + regionHeight / 2 - arcRadius;
        g2d.draw(new Arc2D.Double(arcX, arcY, 2 * arcRadius, 2 * arcRadius, 0, 180, Arc2D.OPEN));

        // Ellipse
        g2d.setColor(Color.YELLOW);
        int ellipseWidth = regionWidth / 2;
        int ellipseHeight = regionHeight / 3;
        int ellipseX = regionWidth + regionWidth / 2 - ellipseWidth / 2;
        int ellipseY = regionHeight + regionHeight / 2 - ellipseHeight / 2;
        g2d.fill(new Ellipse2D.Double(ellipseX, ellipseY, ellipseWidth, ellipseHeight));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing Shapes in Four Regions");
        shapes panel = new shapes();
        panel.setPreferredSize(new Dimension(800, 600));
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}