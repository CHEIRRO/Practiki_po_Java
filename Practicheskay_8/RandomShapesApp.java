package Practicheskay_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomShapesApp extends JFrame {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    public RandomShapesApp() {
        setTitle("Random Shapes");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                createShapes(g);
            }
        };

        add(canvas);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.repaint();
            }
        });

        timer.start();
    }

    private void createShapes(Graphics g) {
        for (int i = 0; i < 20; i++) {
            int x = (int) (Math.random() * WIDTH);
            int y = (int) (Math.random() * HEIGHT);
            int width = (int) (Math.random() * 80) + 20;
            int height = (int) (Math.random() * 80) + 20;
            Color color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
            g.setColor(color);
            if (Math.random() < 0.5) {
                g.fillRect(x, y, width, height);
            } else {
                g.fillOval(x, y, width, height);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RandomShapesApp app = new RandomShapesApp();
                app.setVisible(true);
            }
        });
    }
}
