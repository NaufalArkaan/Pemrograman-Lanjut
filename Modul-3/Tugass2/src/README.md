# 🎓 Aplikasi Data Mahasiswa dengan Konsep Refactoring (Java)

Program ini dibuat untuk mendemonstrasikan **konsep OOP (Object-Oriented Programming)** dan berbagai **teknik Refactoring** dalam bahasa pemrograman **Java**.  
Tujuan utama dari program ini adalah meningkatkan keterbacaan, modularitas, dan efisiensi kode dengan tetap mempertahankan fungsionalitas awal.

---

## 🧩 Deskripsi Singkat

Program ini terdiri dari tiga bagian utama:

1. **Kelas `Mahasiswa`** – menyimpan dan menampilkan data mahasiswa.
2. **Kelas `Kampus`** – menampilkan informasi kampus dan mahasiswa yang terdaftar.
3. **Interface `infoKampus`** – mendefinisikan kontrak method `tampilInfo()` untuk kelas yang mengimplementasikannya.

Pengguna dapat melihat hasil refactoring berupa penerapan prinsip **Encapsulation**, **Extract Method**, **Introduce Constant**, serta **Refactor Rename**.

---

## ⚙️ Fitur Program

✅ Input data mahasiswa (nama, NIM, jurusan, IPK)  
✅ Penentuan status kelulusan berdasarkan nilai IPK minimal  
✅ Menampilkan informasi mahasiswa beserta kampusnya  
✅ Mengimplementasikan interface `infoKampus`  
✅ Dilengkapi dengan berbagai teknik **Refactoring Java**

---

## 🧠 Teknik Refactoring yang Diterapkan

| Jenis Refactor                | Penjelasan                                                                                       |
|-------------------------------|--------------------------------------------------------------------------------------------------|
| **Encapsulate Fields**        | Mengubah atribut `nama`, `nim`, `jurusan`, dan `ipk` menjadi `private` dengan getter/setter.     |
| **Extract Method**            | Memisahkan logika pengecekan kelulusan ke method `statusKelulusan()`.                            |
| **Introduce Constant**        | Menambahkan `MINIMAL_KELULUSAN` sebagai konstanta agar mudah diubah dan dipahami.                |
| **Rename Parameter & Field**  | Mengganti nama variabel agar lebih deskriptif dan konsisten.                                     |
| **Move Members**              | Memindahkan logika tertentu dari `Main` ke kelas lain untuk modularisasi kode.                   |
| **Extract Interface**         | Membuat interface `infoKampus` untuk mendefinisikan kontrak method `tampilInfo()`.               |

---

## 📂 Struktur Folder

```
├── Source/
    ├── code/
        ├── Main.java
        ├── Mahasiswa.java
        ├── Kampus.java
    ├── informasi/
        └── infoKampus.java
```

---

## 📝 Kode Program Utama

### 🔹 Main.java
```java
public class Main { // Hasil Refactor Move Members
    public static void main(String[] args) {
        Mahasiswa m1 = new Mahasiswa("Naufal Arkaan", "202410370110020", "Informatika", 3.5);
        Kampus k1 = new Kampus(m1, "Universitas Muhammadiyah Malang");
        
        k1.tampilInfo();
    }
}