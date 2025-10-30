package source.code;
/**
 * Kelas {@code Kampus} digunakan untuk mengelola dan menampilkan
 * informasi kampus tempat mahasiswa terdaftar.
 * <p>
 * Kelas ini juga mengimplementasikan interface {@link source.informasi.infoKampus}
 * untuk menampilkan informasi kampus dan mahasiswa yang terkait.
 * </p>
 *
 * @author Naufal
 * @version 1.0
 */
public class Kampus implements source.informasi.infoKampus {
    /** Objek mahasiswa yang terdaftar di kampus ini. */
    private Mahasiswa mahasiswa; //Refactor Rename
    /** Nama kampus tempat mahasiswa belajar. */
    private String namaKampus; //Refactor Encapsulate Fields

    /**
     * Konstruktor untuk membuat objek {@code Kampus} baru.
     *
     * @param mahasiswa  objek {@link Mahasiswa} yang terdaftar
     * @param namaKampus nama kampus mahasiswa
     */
    public Kampus(Mahasiswa mahasiswa, String namaKampus) {
        setMahasiswa(mahasiswa);
        setNamaKampus(namaKampus);
    }

    /**
     * Menampilkan informasi kampus beserta data mahasiswa terkait.
     * <p>
     * Implementasi dari metode {@link source.informasi.infoKampus#tampilInfo()}.
     * </p>
     */
    @Override
    public void tampilInfo() { //Refactor Extract interface
        System.out.println("Nama Kampus: " + getNamaKampus());
        getMahasiswa().tampilData();
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public String getNamaKampus() {
        return namaKampus;
    }

    public void setNamaKampus(String namaKampus) {
        this.namaKampus = namaKampus;
    }
}
