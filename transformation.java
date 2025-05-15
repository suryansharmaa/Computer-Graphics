import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class transformation extends JPanel {

    private Shape originalShape;
    private AffineTransform transform;

    public transformation() {
        originalShape = new Rectangle2D.Double(50, 50, 100, 80);
        transform = new AffineTransform();
    }

    // Translation
    public void translate(double tx, double ty) {
        transform.translate(tx, ty);
        repaint();
    }

    // Rotation about the origin (0,0)
    public void rotate(double angleInRadians) {
        transform.rotate(angleInRadians);
        repaint();
    }

    // Rotation about a specific point (rx, ry)
    public void rotate(double angleInRadians, double rx, double ry) {
        transform.rotate(angleInRadians, rx, ry);
        repaint();
    }

    // Scaling
    public void scale(double sx, double sy) {
        transform.scale(sx, sy);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.BLUE);
        g2d.draw(originalShape);

        Shape transformedShape = transform.createTransformedShape(originalShape);

        g2d.setColor(Color.RED);
        g2d.fill(transformedShape);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("2D Transformations");
        transformation panel = new transformation();
        frame.add(panel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Example usage:
        // panel.translate(50, 20); // Translate by (50, 20)
        // panel.rotate(Math.toRadians(45)); // Rotate by 45 degrees about the origin
        // panel.rotate(Math.toRadians(30), 100, 100); // Rotate by 30 degrees about
        // (100, 100)
        // panel.scale(1.5, 0.8); // Scale by 1.5 in x and 0.8 in y
    }
}
