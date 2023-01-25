package projava;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class drawing {
    public static void main(String[] args) {
        var frame = new JFrame("drawing");
        var label = new JLabel("test");
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        var image = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);
        label.setIcon(new ImageIcon(image));
        frame.pack();

        var g = image.createGraphics();
        g.drawLine(0, 0, 600,400);
        label.repaint();

        g.setColor(java.awt.Color.RED);
        g.fillRect(300, 200, 150, 100);
        label.repaint();

        frame.setVisible(true);
    }
}
