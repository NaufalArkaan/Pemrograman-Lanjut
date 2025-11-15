public class Film {
    private final String judul;
    private final int tahunRilis;

    public Film(String judul, int tahunRilis) {
        this.judul = judul;
        this.tahunRilis = tahunRilis;
    }

    public String getJudul() {
        return judul;
    }

    public int getTahunRilis() {
        return tahunRilis;
    }

    @Override
    public String toString() {
        return "Judul: " + judul + ", Tahun: " + tahunRilis;
    }
}