
package Pertemuan1.Tugas1;

import java.awt.*;
import javax.swing.*;
import java.util.Arrays;

public class main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(main::tampil);
    }

    private static void tampil() {

        JFrame frame = new JFrame("Formulir Pendaftaran Kegiatan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel utama = new JPanel(new BorderLayout(10, 10));
        utama.setBorder(
            BorderFactory.createEmptyBorder(15, 20, 15, 20)
        );

        JLabel judul = new JLabel(
            "FORMULIR PENDAFTARAN KEGIATAN",
            SwingConstants.CENTER
        );
        judul.setFont(new Font("Arial", Font.BOLD, 18));

        utama.add(judul, BorderLayout.NORTH);

        JPanel isi = new JPanel(new GridLayout(4, 1, 10, 10));


        //  IDENTITAS PESERTA
        JPanel identitas = new JPanel(new GridLayout(3, 2, 8, 8));
        identitas.setBorder(
            BorderFactory.createTitledBorder("Identitas Peserta")
        );

        JTextField namaField = new JTextField(20);
        JTextField nimField = new JTextField(20);
        JTextField prodiField = new JTextField(20);

        identitas.add(new JLabel("Nama Lengkap:"));
        identitas.add(namaField);

        identitas.add(new JLabel("NIM:"));
        identitas.add(nimField);

        identitas.add(new JLabel("Program Studi:"));
        identitas.add(prodiField);

        // PILIHAN KEGIATAN
        JPanel kegiatan = new JPanel(new GridLayout(2, 2, 8, 8));
        kegiatan.setBorder(
            BorderFactory.createTitledBorder("Pilihan Kegiatan")
        );

        String[] daftarKegiatan = {
            "Seminar Teknologi",
            "Workshop Programming",
            "Lomba IT",
            "Pelatihan Desain"
        };

        JComboBox<String> comboKegiatan =
            new JComboBox<>(daftarKegiatan);

        JRadioButton laki = new JRadioButton("Laki-laki");
        JRadioButton perempuan = new JRadioButton("Perempuan");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(laki);
        genderGroup.add(perempuan);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.add(laki);
        genderPanel.add(perempuan);

        kegiatan.add(new JLabel("Pilih Kegiatan:"));
        kegiatan.add(comboKegiatan);

        kegiatan.add(new JLabel("Jenis Kelamin:"));
        kegiatan.add(genderPanel);

        // MINAT TAMBAHAN
        JPanel minat = new JPanel(new FlowLayout(FlowLayout.LEFT));
        minat.setBorder(
            BorderFactory.createTitledBorder("Minat Tambahan")
        );

        JCheckBox sertifikat = new JCheckBox("Sertifikat");
        JCheckBox konsumsi = new JCheckBox("Konsumsi");
        JCheckBox dokumentasi = new JCheckBox("Dokumentasi");

        minat.add(sertifikat);
        minat.add(konsumsi);
        minat.add(dokumentasi);

        // CATATAN
        JPanel catatan = new JPanel(new BorderLayout(5, 5));
        catatan.setBorder(
            BorderFactory.createTitledBorder("Catatan")
        );

        JTextArea catatanArea = new JTextArea(3, 20);
        catatanArea.setLineWrap(true);
        catatanArea.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(catatanArea);
        catatan.add(scroll, BorderLayout.CENTER);

        isi.add(identitas);
        isi.add(kegiatan);
        isi.add(minat);
        isi.add(catatan);

        utama.add(isi, BorderLayout.CENTER);

        // TOMBOL DAN STATUS
        JPanel bawah = new JPanel(new BorderLayout(10, 5));

        JLabel status = new JLabel("Silakan isi formulir pendaftaran.");

        JButton daftarButton = new JButton("Daftar");
        JButton resetButton = new JButton("Reset");

        JPanel tombol = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        tombol.add(resetButton);
        tombol.add(daftarButton);

        bawah.add(status, BorderLayout.CENTER);
        bawah.add(tombol, BorderLayout.EAST);

        utama.add(bawah, BorderLayout.SOUTH);

        // EVENT LISTENER
        daftarButton.addActionListener(e -> {

            if (namaField.getText().trim().isEmpty()
                    || nimField.getText().trim().isEmpty()
                    || prodiField.getText().trim().isEmpty()) {

                status.setText("Nama, NIM, dan Prodi wajib diisi.");
                return;
            }

            if (!laki.isSelected() && !perempuan.isSelected()) {
                status.setText("Silakan pilih jenis kelamin.");
                return;
            }

            status.setText("Formulir berhasil divalidasi!");
        });

        resetButton.addActionListener(e -> {
            namaField.setText("");
            nimField.setText("");
            prodiField.setText("");
            comboKegiatan.setSelectedIndex(0);
            genderGroup.clearSelection();
            sertifikat.setSelected(false);
            konsumsi.setSelected(false);
            dokumentasi.setSelected(false);
            catatanArea.setText("");

            status.setText("Formulir berhasil dikosongkan.");
            namaField.requestFocusInWindow();
        });

        //Urutan Fokus
        utama.setFocusCycleRoot(true);

        utama.setFocusTraversalPolicy(
        new FocusTraversalPolicy() {

            private final java.util.List<Component> urutan =
                Arrays.asList(
                 namaField,
                    nimField,
                    prodiField,
                    comboKegiatan,
                    laki,
                    perempuan,
                    sertifikat,
                    konsumsi,
                    dokumentasi,
                    catatanArea,
                    resetButton,
                    daftarButton
                );

            @Override
            public Component getComponentAfter(
                   Container a, Component c) {
                 int i = urutan.indexOf(c);
               return urutan.get((i + 1) % urutan.size());
         }   

            @Override
            public Component getComponentBefore(
                 Container a, Component c) {
                int i = urutan.indexOf(c);
                return urutan.get(
                    (i - 1 + urutan.size()) % urutan.size()
                );
         }

            @Override
            public Component getFirstComponent(Container a) {
                return urutan.get(0);
            }

            @Override
            public Component getLastComponent(Container a) {
                return urutan.get(urutan.size() - 1);
            }

            @Override
            public Component getDefaultComponent(Container a) {
                return urutan.get(0);
         }
        });

        frame.setContentPane(utama);
        frame.pack();
        frame.setMinimumSize(new Dimension(700, 600));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
