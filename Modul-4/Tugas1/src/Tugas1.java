import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Tugas1 {

    public static void main(String[] args) {
        ArrayList<Film> daftarFilm = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0;

        do {
            tampilkanMenu();
            System.out.print("Masukkan pilihan (1-4): ");

            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        tambahFilm(scanner, daftarFilm);
                        break;
                    case 2:
                        urutkanDanTampilkan(daftarFilm, "Nama (A-Z)");
                        break;
                    case 3:
                        urutkanDanTampilkan(daftarFilm, "Tahun Rilis (Ascending)");
                        break;
                    case 4:
                        System.out.println("Keluar dari program.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } else {
                System.out.println("Input tidak valid. Silakan masukkan angka.");
                scanner.nextLine();
                pilihan = 0;
            }

            System.out.println("\n-------------------------------------");

        } while (pilihan != 4);

        scanner.close();
    }

    public static void tampilkanMenu() {
        System.out.println("\n=== Menu Manajemen Film ===");
        System.out.println("1. Tambah Film Baru");
        System.out.println("2. Urutkan Berdasarkan Nama Film (A-Z)");
        System.out.println("3. Urutkan Berdasarkan Tahun Rilis (Ascending)");
        System.out.println("4. Keluar Program");
    }

    public static void tambahFilm(Scanner scanner, ArrayList<Film> daftarFilm) {
        System.out.print("Masukkan Judul Film: ");
        String judul = scanner.nextLine();

        int tahun = 0;
        boolean tahunValid = false;
        while (!tahunValid) {
            System.out.print("Masukkan Tahun Rilis: ");
            if (scanner.hasNextInt()) {
                tahun = scanner.nextInt();
                scanner.nextLine();
                tahunValid = true;
            } else {
                System.out.println("Error: Tahun rilis harus berupa angka.");
                scanner.nextLine();
            }
        }

        Film filmBaru = new Film(judul, tahun);
        daftarFilm.add(filmBaru);
        System.out.println("Film berhasil ditambahkan.");
    }

    public static void urutkanDanTampilkan(ArrayList<Film> daftarFilm, String jenisUrutan) {
        if (daftarFilm.isEmpty()) {
            System.out.println("Daftar film kosong. Silakan tambahkan film terlebih dahulu.");
            return;
        }

        if (jenisUrutan.contains("Nama")) {
            Collections.sort(daftarFilm, Comparator.comparing(Film::getJudul));
            System.out.println("=== Daftar Film (Urut Nama A-Z) ===");
        } else if (jenisUrutan.contains("Tahun Rilis")) {
            Collections.sort(daftarFilm, Comparator.comparingInt(Film::getTahunRilis));
            System.out.println("=== Daftar Film (Urut Tahun Ascending) ===");
        }

        for (Film film : daftarFilm) {
            System.out.println(film);
        }
    }
}