import java.util.Random;
import java.util.Scanner;

public class Codelab2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int pilihan = 0;

        do {
            tampilkanMenu();
            System.out.print("Pilihan: ");

            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        menghasilkanBilanganBulatAcak(scanner, random);
                        break;
                    case 2:
                        mengambilKarakterAcak(scanner, random);
                        break;
                    case 3:
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

            System.out.println("---");

        } while (pilihan != 3);

        scanner.close();
    }

    public static void tampilkanMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Menghasilkan Bilangan Bulat Acak");
        System.out.println("2. Mengambil Karakter Acak dari String");
        System.out.println("3. Keluar");
    }

    public static void menghasilkanBilanganBulatAcak(Scanner scanner, Random random) {
        try {
            System.out.print("Masukkan nilai minimum: ");
            String inputMin = scanner.nextLine().trim();

            if (inputMin.isEmpty()) {
                throw new Exception("Input minimum tidak boleh kosong!");
            }

            if (inputMin.matches(".*[\"'].*")) {
                throw new Exception("Input minimum tidak boleh mengandung tanda petik!");
            }

            if (!inputMin.matches("-?\\d+")) {
                throw new Exception("Input minimum harus berupa angka bulat!");
            }

            int min = Integer.parseInt(inputMin);

            System.out.print("Masukkan nilai maksimum: ");
            String inputMax = scanner.nextLine().trim();

            if (inputMax.isEmpty()) {
                throw new Exception("Input maksimum tidak boleh kosong!");
            }

            if (inputMax.matches(".*[\"'].*")) {
                throw new Exception("Input maksimum tidak boleh mengandung tanda petik!");
            }

            if (!inputMax.matches("-?\\d+")) {
                throw new Exception("Input maksimum harus berupa angka bulat!");
            }

            int max = Integer.parseInt(inputMax);

            if (min > max) {
                throw new Exception("Nilai minimum tidak boleh lebih besar dari nilai maksimum!");
            }

            int bilanganAcak = random.nextInt(max - min + 1) + min;
            System.out.println("Bilangan bulat acak antara " + min + " dan " + max + ": " + bilanganAcak);

        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    public static void mengambilKarakterAcak(Scanner scanner, Random random) {
        System.out.print("Masukkan sebuah kata/kalimat: ");
        String inputString = scanner.nextLine();

        if (inputString.isEmpty()) {
            System.out.println("Input string kosong. Tidak ada karakter yang bisa dipilih.");
            return;
        }
        if (inputString.matches(".*[\"'].*")) {
            System.out.println("Input tidak boleh mengandung tanda petik.");
        }

        int panjangString = inputString.length();

        int indeksAcak = random.nextInt(panjangString);

        char karakterAcak = inputString.charAt(indeksAcak);

        System.out.println("Karakter acak dari string: " + karakterAcak);
    }
}