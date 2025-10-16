public class Main { //Hasil Refactor Move Members
    public static void main(String[] args) {
        Mahasiswa m1 = new Mahasiswa("Naufal Arkaan", "202410370110020", "Informatika", 3.5);
        Kampus k1 = new Kampus(m1, "Universitas Muhammadiyah Malang");

        k1.tampilInfo();
    }
}
