package Latihan;

import javax.swing.*;
import java.awt.*;

public class main {
    static void tmpil() {
        JFrame f = new JFrame("Form Inventory");
        CardLayout layout = new CardLayout();
        JPanel kartu = new JPanel(layout);
        JPanel form = new JPanel(new GridLayout(3, 2, 8, 8));
        JTextField nama = new JTextField(16), stok = new JTextField();
        JButton tinjau = new JButton("Tinjau");
        form.add(new JLabel("Nama")); form.add(nama);
        form.add(new JLabel("Stok")); form.add(stok);
    }
}
