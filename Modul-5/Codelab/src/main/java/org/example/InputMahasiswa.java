package org.example;

import java.io.IOException;
import java.util.Scanner;

public class InputMahasiswa {

    private static final String FILE_NAME = "data_mahasiswa.xlsx";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MahasiswaExcelManager excelManager = new MahasiswaExcelManager(FILE_NAME);

        System.out.println("=== Aplikasi Data Mahasiswa (CRUD Excel) ===");

        while (true) {
            System.out.println("\nPilih Operasi:");
            System.out.println("1. Tambah Data (Create)");
            System.out.println("2. Tampilkan Semua Data (Read)");
            System.out.println("3. Update Data");
            System.out.println("4. Hapus Data (Delete)");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan (1-5): ");

            String pilihan = scanner.nextLine();

            try {
                switch (pilihan) {
                    case "1":
                        createData(scanner, excelManager);
                        break;
                    case "2":
                        readData(excelManager);
                        break;
                    case "3":
                        updateData(scanner, excelManager);
                        break;
                    case "4":
                        deleteData(scanner, excelManager);
                        break;
                    case "5":
                        System.out.println("\nTerima kasih! Program selesai.");
                        scanner.close();
                        return; // Keluar dari program
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (IOException e) {
                System.err.println("Terjadi kesalahan I/O pada file Excel: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Terjadi kesalahan tak terduga: " + e.getMessage());
            }
        }
    }

    // --- CREATE Operation ---
    private static void createData(Scanner scanner, MahasiswaExcelManager excelManager) throws IOException {
        System.out.println("\n--- Tambah Data Mahasiswa ---");
        String nama;

        while (true) {
            System.out.print("Masukkan Nama (Ketik 'selesai' untuk batal): ");
            nama = scanner.nextLine().trim();
            if (nama.equalsIgnoreCase("selesai")) {
                System.out.println("Pembatalan penambahan data.");
                return;
            }
            if (excelManager.isNameExists(nama)) {
                System.out.println("Nama sudah ada, masukkan nama yang berbeda!");
            } else if (nama.isEmpty()) {
                System.out.println("Nama tidak boleh kosong!");
            } else {
                break;
            }
        }

        System.out.print("Masukkan Semester: ");
        String semester = scanner.nextLine().trim();

        System.out.print("Masukkan Mata Kuliah: ");
        String mataKuliah = scanner.nextLine().trim();

        excelManager.create(nama, semester, mataKuliah);
        System.out.println("\nData berhasil disimpan ke dalam file " + FILE_NAME + "!");
    }

    // --- READ Operation ---
    private static void readData(MahasiswaExcelManager excelManager) throws IOException {
        System.out.println("\n--- Tampilkan Semua Data Mahasiswa ---");
        excelManager.readAll();
    }

    // --- UPDATE Operation ---
    private static void updateData(Scanner scanner, MahasiswaExcelManager excelManager) throws IOException {
        System.out.println("\n--- Update Data Mahasiswa ---");
        System.out.print("Masukkan Nama mahasiswa yang datanya ingin diubah: ");
        String namaToUpdate = scanner.nextLine().trim();

        if (excelManager.isNameExists(namaToUpdate)) {
            System.out.println("Data ditemukan. Masukkan nilai baru (biarkan kosong untuk tidak mengubah):");

            System.out.print("Masukkan Semester baru: ");
            String newSemester = scanner.nextLine().trim();

            System.out.print("Masukkan Mata Kuliah baru: ");
            String newMataKuliah = scanner.nextLine().trim();

            // Panggil method update
            excelManager.update(namaToUpdate, newSemester, newMataKuliah);
            System.out.println("\nData untuk " + namaToUpdate + " berhasil diupdate!");
        } else {
            System.out.println("\nData dengan Nama: " + namaToUpdate + " tidak ditemukan.");
        }
    }

    // --- DELETE Operation ---
    private static void deleteData(Scanner scanner, MahasiswaExcelManager excelManager) throws IOException {
        System.out.println("\n--- Hapus Data Mahasiswa ---");
        System.out.print("Masukkan Nama mahasiswa yang ingin dihapus: ");
        String namaToDelete = scanner.nextLine().trim();

        if (excelManager.isNameExists(namaToDelete)) {
            excelManager.delete(namaToDelete);
            System.out.println("\nData untuk " + namaToDelete + " berhasil dihapus!");
        } else {
            System.out.println("\nData dengan Nama: " + namaToDelete + " tidak ditemukan.");
        }
    }
}