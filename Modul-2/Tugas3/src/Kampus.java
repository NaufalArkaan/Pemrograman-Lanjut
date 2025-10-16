class Kampus {
    public Mahasiswa mhs;
    public String namaKampus;

    public Kampus(Mahasiswa m, String nK) {
        mhs = m;
        namaKampus = nK;
    }

    public void tampilInfo() {
        System.out.println("Nama Kampus: " + namaKampus);
        mhs.tampilData();
    }
}