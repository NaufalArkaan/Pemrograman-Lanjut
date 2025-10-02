import java.util.Scanner;

public class Tugas3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Masukan nama mahasiswa: ");
        String nama = scan.nextLine();

        System.out.print("Masukan nilai akhir ujian: ");
        int nilai = scan.nextInt();

        if(nama.trim().isEmpty()){
            System.out.println("Nama mahasiswa tidak boleh kosong.");
            scan.close();
            return;
        }

        String status;
        if(nilai >= 60){
            status = "Lulus";
        }else{
            status = "Tidak lulus";
        }

        System.out.println("-------------------------------");
        System.out.println("Nama Mahasiswa: " + nama);
        System.out.println("Status: " + status);

        scan.close();
    }
}

/*
Deskripsi Formal dan Informal:
P(Precondition) C(Command) Q(Postcondition)

P: {nama ≠ "" ∧ (0 ≤ nilai ≤ 100)}

C: Input(nama, nilai);
    if (nama.trim() = "") then
         Output("Nama mahasiswa tidak boleh kosong.");
         stop;
    else
        if (nilai ≥ 60) then
            status ← "Lulus"
        else
            status ← "Tidak Lulus";

Q: { (nama = "" ⇒ program berhenti dengan pesan error) ∧
     (status = "Lulus" ⇔ nilai ≥ 60) ∧
     (status = "Tidak Lulus" ⇔ nilai < 60) }

Deskripsi Informal:
1.Program meminta pengguna memasukkan nama mahasiswa.
2. Program kemudian meminta pengguna memasukkan nilai ujian akhir dengan rentang 0–100.
3. Program memeriksa apakah nama mahasiswa kosong:
    - Jika kosong, program akan menampilkan pesan "Nama mahasiswa tidak boleh kosong" lalu berhenti.
    - Jika tidak kosong, program lanjut memeriksa nilai.
4. Jika nilai ujian akhir ≥ 60, maka status mahasiswa adalah "Lulus".
5. Jika nilai ujian akhir < 60, maka status mahasiswa adalah "Tidak Lulus".
6. Program menampilkan nama mahasiswa beserta status kelulusannya.
*/
