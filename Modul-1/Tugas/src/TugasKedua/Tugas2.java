package TugasKedua;

//import TugasKedua.InvalidNumberException;
import java.util.Scanner;

public class Tugas2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try{
            System.out.print("Masukkan sebuah angka positif: ");
            int angka = scan.nextInt();

            validasiAngkaPositif(angka);

            System.out.println("Angka positif: " + angka);
        }catch(InvalidNumberException e){
            System.out.println("Kesalahan: " + e.getMessage());
        }catch (Exception e){
            System.out.println("Input tidak valid, pastikan Anda memasukkan angka!");
        }finally {
            scan.close();
        }
    }

    public static void validasiAngkaPositif(int num) throws InvalidNumberException{
        if (num <= 0){
            throw new InvalidNumberException("Angka tidak boleh sama dengan nol dan kurang dari nol");
        }
    }
}
