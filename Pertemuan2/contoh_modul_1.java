import javax.swing.*;
import java.awt.*;

public class contoh_modul_1 {
    private int JumlahKlik = 0;

    private void tampilan () {
        JFrame frame = new JFrame("Contoh Modul 1");
        JLabel pesan = new JLabel("Tekan Tombol Ini");
        JButton tombol = new JButton("Klik Saya");

        tombol.addActionListener(event -> {
            JumlahKlik++;
            pesan.setText("Saya Sudah Mengklik Sebanyak: " + JumlahKlik);
        });

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(pesan, BorderLayout.CENTER);
        panel.add(tombol, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new contoh_modul_1().tampilan());
    }
}