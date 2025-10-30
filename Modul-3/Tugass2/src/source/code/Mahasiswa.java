package source.code;
/**
 * Kelas {@code Mahasiswa} merepresentasikan data seorang mahasiswa
 * yang memiliki atribut dasar seperti nama, NIM, jurusan, dan IPK.
 * <p>
 * Kelas ini berfungsi untuk menyimpan serta menampilkan informasi
 * tentang identitas mahasiswa.
 * </p>
 *
 * @author Naufal
 * @version 1.0
 */
public class Mahasiswa {
    public static final double MINIMAL_KELULUSAN = 3.0;
    /** Nama lengkap mahasiswa. */
    private String nama; //Refactor Encapsulate Fields
    /** Nomor Induk Mahasiswa (NIM). */
    private String nim;
    /** Program studi atau jurusan mahasiswa. */
    private String jurusan;
    /** Indeks Prestasi Kumulatif (IPK) mahasiswa. */
    private double ipk;

    /**
     * Konstruktor untuk membuat objek {@code Mahasiswa} baru dengan data lengkap.
     *
     * @param nama     nama mahasiswa
     * @param nim      nomor induk mahasiswa
     * @param jurusan  jurusan mahasiswa
     * @param ipk      IPK mahasiswa
     */
    public Mahasiswa(String nama, String nim, String jurusan, double ipk) { //Refactoring Rename Parameter
        this.setNama(nama);
        this.setNim(nim);
        this.setJurusan(jurusan);
        this.setIpk(ipk);
    }

    /**
     * Menampilkan informasi lengkap mahasiswa ke layar.
     */
    public void tampilData() {
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
        System.out.println("Jurusan: " + getJurusan());
        System.out.println("IPK: " + getIpk());
        statusKelulusan(); //Refactor Extract Method, yang awalnya percabangan if else jadi buat method sendiri
    }

    private void statusKelulusan() {
        if (getIpk() >= MINIMAL_KELULUSAN) { //Refactor Introduce Constant
            System.out.println("Status: Lulus");
        } else {
            System.out.println("Status: Tidak Lulus");
        }
    }

    /** @return nama mahasiswa */
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    /** @return NIM mahasiswa */
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    /** @return jurusan mahasiswa */
    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    /** @return IPK mahasiswa */
    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }
}