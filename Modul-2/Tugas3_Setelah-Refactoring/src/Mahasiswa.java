class Mahasiswa {
    public static final double MINIMAL_KELULUSAN = 3.0;
    private String nama; //Refactor Encapsulate Fields
    private String nim;
    private String jurusan;
    private double ipk;

    public Mahasiswa(String nama, String nim, String jurusan, double ipk) { //Refactoring Rename Parameter
        this.setNama(nama);
        this.setNim(nim);
        this.setJurusan(jurusan);
        this.setIpk(ipk);
    }

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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }
}