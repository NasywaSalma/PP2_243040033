package Pertemuan1;

import javax.swing.*;

public class latihan1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Hello World");
            frame.add(new JLabel("Hello PP2!", JLabel.CENTER));
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}