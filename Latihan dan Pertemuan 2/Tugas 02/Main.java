import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Main {
    static JFrame frame = new JFrame("Pendaftaran Kegiatan");
    static CardLayout card = new CardLayout();
    static JPanel utama = new JPanel(card);
    static JTextField nama = new JTextField();
    static JTextField email = new JTextField();
    static JTextField umur = new JTextField();
    static JComboBox<String> kegiatan = new JComboBox<>(
        new String[]{"Pilih Kegiatan", "Seminar", "Workshop", "Lomba"}
    );

    static JTextArea hasil = new JTextArea();
    static boolean berubah = false;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

        // Halaman Formulir
        JPanel form = new JPanel(new GridLayout(6, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        form.add(new JLabel("Nama:"));
        form.add(nama);
        form.add(new JLabel("Email:"));
        form.add(email);
        form.add(new JLabel("Umur:"));
        form.add(umur);
        form.add(new JLabel("Kegiatan:"));
        form.add(kegiatan);

        JButton simpan = new JButton("Simpan / Tampilkan");
        JButton reset = new JButton("Reset");

        form.add(simpan);
        form.add(reset);

        JButton bantuan = new JButton("Bantuan");
        form.add(bantuan);

        // Halaman Ringkasan
        JPanel ringkasan = new JPanel(new BorderLayout());

        hasil.setEditable(false);
        ringkasan.add(new JLabel("Ringkasan Pendaftaran"), BorderLayout.NORTH);
        ringkasan.add(new JScrollPane(hasil), BorderLayout.CENTER);

        JButton kembali = new JButton("Kembali");
        ringkasan.add(kembali, BorderLayout.SOUTH);
        JPanel help = new JPanel(new BorderLayout());
        JTextArea info = new JTextArea(
            "BANTUAN PENDAFTARAN\n\n" +
            "1. Isi nama lengkap.\n" +
            "2. Masukkan email yang valid.\n" +
            "3. Masukkan umur 15-100 tahun.\n" +
            "4. Pilih kegiatan.\n" +
            "5. Klik Simpan / Tampilkan."
        );

        info.setEditable(false);
        help.add(info, BorderLayout.CENTER);
        JButton kembaliHelp = new JButton("Kembali ke Form");
        help.add(kembaliHelp, BorderLayout.SOUTH);

        // Menggabungkan halaman
        utama.add(form, "FORM");
        utama.add(ringkasan, "RINGKASAN");
        utama.add(help, "BANTUAN");

        // Mendeteksi perubahan input
        DocumentListener listener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                berubah = true;
            }
            public void removeUpdate(DocumentEvent e) {
                berubah = true;
            }
            public void changedUpdate(DocumentEvent e) {
                berubah = true;
            }
        };

        nama.getDocument().addDocumentListener(listener);
        email.getDocument().addDocumentListener(listener);
        umur.getDocument().addDocumentListener(listener);
        kegiatan.addActionListener(e -> berubah = true);

        // Event Simpan / Tampilkan
        simpan.addActionListener(e -> {
            String n = nama.getText().trim();
            String em = email.getText().trim();
            String u = umur.getText().trim();
            String k = (String) kegiatan.getSelectedItem();
            if (n.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                    "Nama wajib diisi!");
                nama.requestFocus();
                return;
            }
            if (!em.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                JOptionPane.showMessageDialog(frame,
                    "Format email tidak valid!");
                email.requestFocus();
                return;
            }
            int usia;
            try {
                usia = Integer.parseInt(u);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame,
                    "Umur harus berupa bilangan bulat!");
                umur.requestFocus();
                umur.selectAll();
                return;
            }
            if (usia < 15 || usia > 100) {
                JOptionPane.showMessageDialog(frame,
                    "Umur harus antara 15-100 tahun!");
                umur.requestFocus();
                umur.selectAll();
                return;
            }
            if (k.equals("Pilih Kegiatan")) {
                JOptionPane.showMessageDialog(frame,
                    "Silakan pilih kegiatan!");
                kegiatan.requestFocus();
                return;
            }
            hasil.setText(
                "Nama       : " + n +
                "\nEmail      : " + em +
                "\nUmur       : " + usia +
                "\nKegiatan   : " + k
            );
            berubah = false;
            card.show(utama, "RINGKASAN");
        });

        // Event Reset
        reset.addActionListener(e -> {
            nama.setText("");
            email.setText("");
            umur.setText("");
            kegiatan.setSelectedIndex(0);
            hasil.setText("");
            berubah = false;
            nama.requestFocus();
        });
        // Event Kembali
        kembali.addActionListener(e -> {
            card.show(utama, "FORM");
            nama.requestFocus();
        });
        // Event Bantuan
        bantuan.addActionListener(e ->
            card.show(utama, "BANTUAN")
        );
        kembaliHelp.addActionListener(e ->
            card.show(utama, "FORM")
        );
        // Event Keluar
        JButton keluar = new JButton("Keluar");
        form.add(keluar);
        keluar.addActionListener(e -> {
            if (berubah) {
                int jawab = JOptionPane.showConfirmDialog(
                    frame,
                    "Ada perubahan yang belum ditampilkan. Yakin ingin keluar?",
                    "Konfirmasi Keluar",
                    JOptionPane.YES_NO_OPTION
                );
                if (jawab == JOptionPane.YES_OPTION) {
                    frame.dispose();
                }
            } else {
                frame.dispose();
            }
        });
        // Pengaturan JFrame
        frame.setContentPane(utama);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                keluar.doClick();
            }
        });
        frame.setVisible(true);
    });
    }
}