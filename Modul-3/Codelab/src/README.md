<p align="left">
  <img src="https://user-images.githubusercontent.com/5679180/79618120-0daffb80-80be-11ea-819e-d2b0fa904d07.gif" width="27px">
</p>

# AutoHashScanner (Java)

## Deskripsi
Program sederhana yang membaca input teks dari pengguna melalui `Scanner`, lalu otomatis melakukan hashing menggunakan SHA-256 dengan salt acak. Hasil salt dan hash ditampilkan dalam format Base64.

Tujuan: contoh edukasional untuk memahami hashing password/text dengan salt.

---

## Struktur File
```
.
├── Main.java
└── README.md
```

## Persyaratan
* Java Development Kit (JDK) terpasang (versi 8+ direkomendasikan).
* Terminal / Command Prompt untuk compile & run.

## Cara compile & jalankan
1. Simpan kode di file `AutoHashScanner.java`.
2. Buka terminal dan arahkan ke folder file tersebut:
   ```
   cd /path/to/folder
   ```
3. Compile:
   ```bash
   javac AutoHashScanner.java
   ```
4. Jalankan:
   ```bash
   java AutoHashScanner.java
   ```

## Contoh interaksi & output
   ```
   Masukkan teks yang ingin di-hash: rahasia123

   Teks asli   : rahasia123
   Hasil hash  : 6a86c058d2ce86e4dd9dc053a68dc949ccab5e5cb58602b4a784ca4b5e89bb9d
   ```

## FAQ singkat
<img align="right" alt="GIF" src="https://i.pinimg.com/originals/e4/26/70/e426702edf874b181aced1e2fa5c6cde.gif" />

Q: Kenapa hasil hash berbeda setiap run meski input sama?
<br/>
A: Pada implementasi ini (SHA-256 tanpa salt), hasil akan sama tiap run untuk input yang sama. Jika kamu menambahkan salt acak, hasil berbeda walau input sama — itu yang diinginkan untuk keamanan.

Q: Apa format output terbaik untuk penyimpanan?
<br/>
A: Base64 atau heksadesimal keduanya umum. Base64 lebih pendek; hex mudah dibaca/debug.

Q: Bagaimana memverifikasi password saat login?
<br/>
A: Ambil salt yang tersimpan, hitung hash dari password yang dimasukkan menggunakan salt itu, lalu bandingkan byte-by-byte dengan hash yang tersimpan.
