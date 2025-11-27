package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class MahasiswaExcelManager {

    private final File file;
    private static final String SHEET_NAME = "Data Mahasiswa";
    private static final String[] HEADERS = {"Nama", "Semester", "Mata Kuliah"};

    public MahasiswaExcelManager(String fileName) {
        File tempFile;
        java.net.URL resourceUrl = getClass().getClassLoader().getResource(fileName);

        if (resourceUrl != null) {
            tempFile = new File(resourceUrl.getFile());
        } else {
            File resourcesDir = new File("src/main/resources/");
            if (!resourcesDir.exists()) {
                resourcesDir.mkdirs(); // Pastikan folder resources ada
            }
            tempFile = new File(resourcesDir, fileName); // Buat file di dalam folder resources
        }

        this.file = tempFile;

        initializeFile();
    }

    // Memastikan file Excel ada dan memiliki header yang benar
    private void initializeFile() {
        if (!this.file.exists()) {
            try (Workbook workbook = new XSSFWorkbook();
                 FileOutputStream outputStream = new FileOutputStream(this.file)) {

                Sheet sheet = workbook.createSheet(SHEET_NAME);

                // Membuat Header Row
                Row headerRow = sheet.createRow(0);
                for (int i = 0; i < HEADERS.length; i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(HEADERS[i]);
                }

                workbook.write(outputStream);
                System.out.println("File Excel berhasil dibuat di: " + this.file.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Gagal membuat file Excel: " + e.getMessage());
            }
        } else {
            System.out.println("File Excel ditemukan di: " + this.file.getAbsolutePath());
        }
    }

    // ------------------------------------ CRUD Operations ------------------------------------

    // CREATE: Menambahkan baris baru ke Excel
    public void create(String nama, String semester, String mataKuliah) throws IOException {
        // Semua operasi I/O menggunakan this.file yang konsisten
        try (FileInputStream inputStream = new FileInputStream(this.file);
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheet(SHEET_NAME);
            if (sheet == null) {
                sheet = workbook.createSheet(SHEET_NAME);
            }

            int rowNum = sheet.getLastRowNum() + 1;
            Row row = sheet.createRow(rowNum);

            row.createCell(0).setCellValue(nama);
            row.createCell(1).setCellValue(semester);
            row.createCell(2).setCellValue(mataKuliah);

            // Tulis perubahan ke file
            try (FileOutputStream outputStream = new FileOutputStream(this.file)) {
                workbook.write(outputStream);
            }
        }
    }

    // READ: Menampilkan semua data dari Excel
    public void readAll() throws IOException {
        try (FileInputStream inputStream = new FileInputStream(this.file);
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheet(SHEET_NAME);
            if (sheet == null) {
                System.out.println("Sheet '" + SHEET_NAME + "' tidak ditemukan.");
                return;
            }

            Iterator<Row> rowIterator = sheet.iterator();

            if (!rowIterator.hasNext()) {
                System.out.println("Data kosong.");
                return;
            }

            // Skip Header
            Row headerRow = rowIterator.next();
            System.out.printf("| %-20s | %-10s | %-30s |%n", "NAMA", "SEMESTER", "MATA KULIAH");
            System.out.println("|" + "-".repeat(22) + "|" + "-".repeat(12) + "|" + "-".repeat(32) + "|");


            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                String nama = getCellValue(row.getCell(0));
                String semester = getCellValue(row.getCell(1));
                String mataKuliah = getCellValue(row.getCell(2));

                if (!nama.isEmpty()) {
                    System.out.printf("| %-20s | %-10s | %-30s |%n", nama, semester, mataKuliah);
                }
            }
            System.out.println("|" + "-".repeat(22) + "|" + "-".repeat(12) + "|" + "-".repeat(32) + "|");

        }
    }

    // UPDATE: Mengubah data berdasarkan Nama
    public void update(String namaToFind, String newSemester, String newMataKuliah) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(this.file);
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheet(SHEET_NAME);
            if (sheet == null) return;

            // Iterasi dimulai dari baris ke-1 (setelah header)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                Cell namaCell = row.getCell(0);
                String currentName = getCellValue(namaCell);

                if (currentName.equalsIgnoreCase(namaToFind)) {
                    // Update Semester
                    if (!newSemester.isEmpty()) {
                        Cell semesterCell = row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        semesterCell.setCellValue(newSemester);
                    }

                    // Update Mata Kuliah
                    if (!newMataKuliah.isEmpty()) {
                        Cell mataKuliahCell = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        mataKuliahCell.setCellValue(newMataKuliah);
                    }

                    // Tulis perubahan ke file dan keluar
                    try (FileOutputStream outputStream = new FileOutputStream(this.file)) {
                        workbook.write(outputStream);
                    }
                    return;
                }
            }
        }
    }

    // DELETE: Menghapus baris berdasarkan Nama (sudah diperbaiki logic shiftRows)
    public void delete(String namaToFind) throws IOException {
        int rowIndexToDelete = -1;
        boolean dataFound = false;

        // 1. Baca File untuk Menemukan Baris
        try (FileInputStream inputStream = new FileInputStream(this.file);
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheet(SHEET_NAME);
            if (sheet == null) {
                System.err.println("DEBUG: Sheet tidak ditemukan.");
                return;
            }

            // Cari index baris yang akan dihapus (mulai dari 1)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                Cell namaCell = row.getCell(0);
                String currentName = getCellValue(namaCell);

                if (currentName.equalsIgnoreCase(namaToFind)) {
                    rowIndexToDelete = i;
                    dataFound = true;
                    // System.out.println("DEBUG: Data ditemukan di baris index: " + rowIndexToDelete);
                    break;
                }
            }

            if (!dataFound) {
                // System.out.println("DEBUG: Data dengan Nama: " + namaToFind + " tidak ditemukan di sheet.");
                return;
            }


            // 2. Lakukan Penghapusan dan Tulis ke File
            if (rowIndexToDelete != -1) {

                int lastRow = sheet.getLastRowNum();

                if (rowIndexToDelete == lastRow) {
                    // Cukup hapus objek Row jika itu baris terakhir (Mencegah out of order error)
                    Row row = sheet.getRow(rowIndexToDelete);
                    if (row != null) {
                        sheet.removeRow(row);
                        // System.out.println("DEBUG: Baris terakhir dihapus menggunakan removeRow.");
                    }
                } else {
                    // Lakukan shifting jika ada baris di bawahnya
                    sheet.shiftRows(rowIndexToDelete + 1, lastRow, -1);
                    // System.out.println("DEBUG: Baris berhasil digeser.");
                }

                // Tulis perubahan ke file
                try (FileOutputStream outputStream = new FileOutputStream(this.file)) {
                    workbook.write(outputStream);
                    // System.out.println("DEBUG: Perubahan berhasil ditulis ke file.");
                }
            }
        } catch (IOException readException) {
            System.err.println("Gagal Membaca File! File mungkin tidak ada atau rusak. Error: " + readException.getMessage());
            throw readException;
        }
    }


    // ------------------------------------ Helper Methods ------------------------------------

    // Cek apakah nama sudah ada (untuk CREATE dan validasi)
    public boolean isNameExists(String nama) {
        // Semua operasi I/O menggunakan this.file yang konsisten
        try (FileInputStream inputStream = new FileInputStream(this.file);
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheet(SHEET_NAME);
            if (sheet == null) return false;

            // Iterasi dimulai dari baris ke-1 (setelah header)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                Cell namaCell = row.getCell(0);
                String currentName = getCellValue(namaCell);

                if (currentName.equalsIgnoreCase(nama)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            // Jika file belum ada atau error I/O, anggap nama belum ada
            return false;
        }
    }

    // Mendapatkan nilai Cell sebagai String
    private String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }

        // Mengatur tipe cell untuk mendapatkan nilai dengan mudah
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue().trim();
    }
}