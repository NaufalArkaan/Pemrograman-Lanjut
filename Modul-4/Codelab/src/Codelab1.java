import java.util.Scanner;

public class Codelab1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Masukkan sebuah kalimat: ");
            String kalimat = input.nextLine();

            if (kalimat.trim().isEmpty()) {
                throw new Exception("Kalimat tidak boleh kosong!");
            }
            if(kalimat.matches(".*[0-9\"'].*")){
                throw new Exception("Kalimat tidak boleh mengandung angka atau tanda petik");
            }

            String[] kata = kalimat.split(" ");
            String kataKedua = (kata.length >= 2) ? kata[1] : "Tidak ada kata kedua";
            System.out.println("Kata kedua : " + kataKedua);

            String hurufKapital = kalimat.toUpperCase();
            System.out.println("Huruf Kapital : " + hurufKapital);

            boolean mengandungJava = kalimat.toLowerCase().contains("java");
            System.out.println("Apakah mengandung kata 'java'? : " + mengandungJava);

            System.out.print("Masukkan kata/kalimat untuk ditambah di akhir: ");
            String tambahan = input.nextLine();

            if (tambahan.trim().isEmpty()) {
                throw new Exception("Kalimat tambahan tidak boleh kosong!");
            }
            if(tambahan.matches(".*[0-9\"'].*")){
                throw new Exception("Kalimat tidak boleh mengandung angka atau tanda petik");
            }

            String kalimatBaru = kalimat + " " + tambahan;
            System.out.println("Setelah menambah kata/kalimat: " + kalimatBaru);

            StringBuilder sb = new StringBuilder(kalimatBaru);
            sb.reverse();
            System.out.println("Kalimat terbalik: " + sb.toString());

        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            input.close();
        }
    }
}
