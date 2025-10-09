public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter", "J.K Rowling", 10,2);
        Library lib = new Library(book1, "Perpustakaan Kota");

        //Dsiplay Initial Information
        lib.showLibraryInfo();

        //Add More Stock
        book1.adjustStock(5);

        //Display updated information
        lib.showLibraryInfo();
    }
}
