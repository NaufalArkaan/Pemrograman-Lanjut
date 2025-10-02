import java.util.Scanner;

public class Tugas1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.print("Masukkan jumlah angka: ");
            int n = scanner.nextInt();

            if(n <= 0){ //eror handling
                throw new IllegalArgumentException("Angka Harus lebih dari nol");
            }

            int[] angka = new int[n];
            System.out.println("Masukkan angka-angka:");
            for (int i = 0; i < n; i++) {
                angka[i] = scanner.nextInt();
            }

            int total = 0;
            for (int i = 0; i < n; i++) { //array yang awalnya 1 jadi 0
                total += angka[i];
            }

            double rataRata = (double) total / n;
            System.out.println("Rata-rata adalah: " + rataRata);
        } catch (IllegalArgumentException e) {
            System.out.println("Eror: " + e.getMessage()); //menangkap throw new IllegalArgumentException
        } catch (Exception e) {
            System.out.println("Kesalahan Input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}