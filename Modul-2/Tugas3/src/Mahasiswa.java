class Mahasiswa {
    public String nama;
    public String nim;
    public String jurusan;
    public double ipk;

    public Mahasiswa(String n, String ni, String j, double i) {
        nama = n;
        nim = ni;
        jurusan = j;
        ipk = i;
    }

    public void tampilData() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Jurusan: " + jurusan);
        System.out.println("IPK: " + ipk);
        if (ipk >= 3.0) {
            System.out.println("Status: Lulus");
        } else {
            System.out.println("Status: Tidak Lulus");
        }
    }
}