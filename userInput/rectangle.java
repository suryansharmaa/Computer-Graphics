package userInput;

import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class rectangle extends JFrame {

    private int[] xPoints = new int[4];
    private int[] yPoints = new int[4];
    private JPanel drawPanel;

    public rectangle() {
        setTitle("Rectangle");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        drawPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLUE);
                g.fillPolygon(xPoints, yPoints, 4);
            }
        };

        add(drawPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void userInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            for (int i = 0; i < 4; i++) {
                System.out.print("Enter X" + (i + 1) + ": ");
                xPoints[i] = scanner.nextInt();
                System.out.print("Enter Y" + (i + 1) + ": ");
                yPoints[i] = scanner.nextInt();
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid Input. Integers only.");
            System.exit(1);
        } finally {
            scanner.close();
        }
    }

    public static void main(String[] args) {
        rectangle rectangle = new rectangle();
        rectangle.userInput();
        rectangle.drawPanel.repaint();
    }
}