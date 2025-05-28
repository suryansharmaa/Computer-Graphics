import javax.swing.*;
import java.awt.*;

public class cohen_sutherland extends JPanel {

    final int x_min = 100, y_min = 100;
    final int x_max = 300, y_max = 300;

    // Region codes
    final int INSIDE = 0;
    final int LEFT = 1;
    final int RIGHT = 2;
    final int BOTTOM = 4;
    final int TOP = 8;

    int x1 = 50, y1 = 150;
    int x2 = 350, y2 = 250;

    boolean clipped = false;
    int cx1, cy1, cx2, cy2;

    public cohen_sutherland() {
        clipped = cohenSutherlandClip();
    }

    private int computeCode(int x, int y) {
        int code = INSIDE;
        if (x < x_min)
            code |= LEFT;
        else if (x > x_max)
            code |= RIGHT;
        if (y < y_min)
            code |= BOTTOM;
        else if (y > y_max)
            code |= TOP;
        return code;
    }

    private boolean cohenSutherlandClip() {
        int code1 = computeCode(x1, y1);
        int code2 = computeCode(x2, y2);
        boolean accept = false;

        int x, y;

        while (true) {
            if ((code1 | code2) == 0) {
                accept = true;
                cx1 = x1;
                cy1 = y1;
                cx2 = x2;
                cy2 = y2;
                break;
            } else if ((code1 & code2) != 0) {
                break;
            } else {
                int code_out = (code1 != 0) ? code1 : code2;

                if ((code_out & TOP) != 0) {
                    x = x1 + (x2 - x1) * (y_max - y1) / (y2 - y1);
                    y = y_max;
                } else if ((code_out & BOTTOM) != 0) {
                    x = x1 + (x2 - x1) * (y_min - y1) / (y2 - y1);
                    y = y_min;
                } else if ((code_out & RIGHT) != 0) {
                    y = y1 + (y2 - y1) * (x_max - x1) / (x2 - x1);
                    x = x_max;
                } else {
                    y = y1 + (y2 - y1) * (x_min - x1) / (x2 - x1);
                    x = x_min;
                }

                if (code_out == code1) {
                    x1 = x;
                    y1 = y;
                    code1 = computeCode(x1, y1);
                } else {
                    x2 = x;
                    y2 = y;
                    code2 = computeCode(x2, y2);
                }
            }
        }
        return accept;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        g.setColor(Color.BLACK);
        g.drawRect(x_min, y_min, x_max - x_min, y_max - y_min);

        // Draw original line
        g.setColor(Color.BLUE);
        g.drawLine(50, 150, 350, 250);

        if (clipped) {
            g.setColor(Color.RED);
            g.drawLine(cx1, cy1, cx2, cy2);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cohen-Sutherland Line Clipping");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(new cohen_sutherland());
        frame.setVisible(true);
    }
}


