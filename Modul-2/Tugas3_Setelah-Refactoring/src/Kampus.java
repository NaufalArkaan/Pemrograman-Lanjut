class Kampus implements Informasi.infoKampus {
    private Mahasiswa mahasiswa; //Refactor Rename
    private String namaKampus; //Refactor Encapsulate Fields

    public Kampus(Mahasiswa mahasiswa, String namaKampus) {
        setMahasiswa(mahasiswa);
        setNamaKampus(namaKampus);
    }

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