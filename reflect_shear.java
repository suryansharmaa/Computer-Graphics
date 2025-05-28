import javax.swing.*;
import java.awt.*;

public class reflect_shear extends JPanel {

    int[][] shape = {
            { 100, 100 },
            { 150, 50 },
            { 200, 100 }
    };

    int[][] transformed = new int[3][2];

    public reflect_shear() {
        applyReflectionX();
        // applyShearX();
    }

    private void applyReflectionX() {
        for (int i = 0; i < shape.length; i++) {
            transformed[i][0] = shape[i][0];
            transformed[i][1] = 400 - shape[i][1];
        }
    }

    private void applyShearX() {
        int shearFactor = 1;
        for (int i = 0; i < shape.length; i++) {
            transformed[i][0] = shape[i][0] + shearFactor * shape[i][1];
            transformed[i][1] = shape[i][1];
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        g.setColor(Color.BLUE);
        drawShape(g, shape);

        g.setColor(Color.RED);
        drawShape(g, transformed);
    }

    private void drawShape(Graphics g, int[][] s) {
        for (int i = 0; i < s.length; i++) {
            int x1 = s[i][0], y1 = s[i][1];
            int x2 = s[(i + 1) % s.length][0], y2 = s[(i + 1) % s.length][1];
            g.drawLine(x1, y1, x2, y2);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple 2D Transform");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(new reflect_shear());
        frame.setVisible(true);
    }
}
