# README
## Tugas 01 – Dasar GUI Swing dan Layout

### 1. Informasi Project
- **Nama Aplikasi:** Formulir Pendaftaran Kegiatan
- **Bahasa Pemrograman:** Java
- **IDE:** Visual Studio Code
- **JDK:** [Isi versi JDK]
- **Package:** Pertemuan1.Tugas1
- **Main Class:** main

### 2. Deskripsi Aplikasi
Aplikasi Formulir Pendaftaran Kegiatan merupakan aplikasi desktop berbasis Java Swing yang digunakan untuk mengisi identitas peserta, memilih kegiatan, menentukan jenis kelamin, memilih minat tambahan, dan mengisi catatan.

### 3. Tools dan Teknologi
- Visual Studio Code sebagai IDE.
- Java Development Kit (JDK) untuk menjalankan dan mengompilasi program.
- Java Swing dan AWT untuk membangun antarmuka grafis.

### 4. Persiapan
Sebelum menjalankan aplikasi, pastikan:
1. JDK sudah terinstal.
2. Visual Studio Code sudah terinstal.
3. Extension Pack for Java sudah terpasang di VS Code.

### 5. Langkah Build dan Run

**A. Build Program**
1. Buka folder project melalui Visual Studio Code.
2. Buka terminal di VS Code.
3. Pastikan terminal berada pada folder utama project.
4. Kompilasi file Java menggunakan perintah:

```bash
javac -d bin src/Pertemuan1/Tugas1/main.java
```

**B. Run Program**

Jalankan aplikasi menggunakan perintah:

```bash
java -cp bin Pertemuan1.Tugas1.main
```

### 6. Fitur Aplikasi
- Pengisian identitas peserta.
- Pemilihan kegiatan.
- Pemilihan jenis kelamin.
- Pemilihan minat tambahan.
- Pengisian catatan.
- Validasi formulir melalui tombol Daftar.
- Pengosongan formulir melalui tombol Reset.

### 7. Keterangan
Aplikasi menggunakan Java Swing dengan beberapa Layout Manager, yaitu BorderLayout, GridLayout, dan FlowLayout. Program dijalankan menggunakan Event Dispatch Thread (EDT).
