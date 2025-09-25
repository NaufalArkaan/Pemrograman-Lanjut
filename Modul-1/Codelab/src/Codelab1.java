public class Codelab1 {
    public static void main(String[] args) {
        String[] nama = {"Adi", "Budi", "Cahyo", "Diana", "Eva"};
        try {
            String namaTerpanjang = cariNamaTerpanjang(nama);
            System.out.println("Nama terpanjang adalah: " + namaTerpanjang);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String cariNamaTerpanjang(String[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array kosong atau null");
        }

        String namaMax = "";
        for (String nama : array) {
            if (nama == null) continue;
            if (nama.length() > namaMax.length()) {
                namaMax = nama;
            }
        }

        if (namaMax.isEmpty()) {
            throw new IllegalArgumentException("Tidak ada nama valid dalam array");
        }
        return namaMax;
    }
}
