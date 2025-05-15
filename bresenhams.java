import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class bresenhams extends JPanel {

    private final int x1 = 2;
    private final int y1 = 3;
    private final int x2 = 10;
    private final int y2 = 7;

    private final java.util.List<Point> points = new ArrayList<>();

    public bresenhams() {
        calculateBresenhamLine();
    }

    private void calculateBresenhamLine() {
        int x = x1;
        int y = y1;

        int dx = x2 - x1;
        int dy = y2 - y1;
        int p = 2 * dy - dx;

        points.add(new Point(x, y));

        for (int i = 0; i < dx; i++) {
            x = x + 1;
            if (p < 0) {
                p = p + 2 * dy;
            } else {
                y = y + 1;
                p = p + 2 * dy - 2 * dx;
            }
            points.add(new Point(x, y));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Scale the points for visibility
        int scale = 30;
        g.setColor(Color.RED);

        for (Point point : points) {
            g.fillOval(point.x * scale, (10 - point.y) * scale, 8, 8); // invert y for screen coordinates
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bresenham's Line Drawing Algorithm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new bresenhams());
        frame.setVisible(true);
    }
}
