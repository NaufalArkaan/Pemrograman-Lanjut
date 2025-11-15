import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Tugas2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah uang: ");
        double jumlahUang = 0;
        if (scanner.hasNextDouble()) {
            jumlahUang = scanner.nextDouble();
        } else {
            System.out.println("Error: Input jumlah uang tidak valid. Menggunakan nilai 0.");
            scanner.nextLine();
        }
        scanner.nextLine();

        System.out.print("Masukkan tanggal (dd-MM-yyyy): ");
        String tanggalInputString = scanner.nextLine();
        Date tanggal = null;

        SimpleDateFormat dateFormatInput = new SimpleDateFormat("dd-MM-yyyy");
        try {
            tanggal = dateFormatInput.parse(tanggalInputString);
        } catch (ParseException e) {
            System.out.println("Error: Format tanggal tidak sesuai (dd-MM-yyyy). Menggunakan tanggal hari ini.");
            tanggal = new Date(); // Gunakan tanggal hari ini jika parsing gagal
        }

        Locale[] daftarLocale = {
                new Locale("id", "ID"), // Indonesia
                new Locale("ja", "JP"), // Jepang
                new Locale("en", "US")  // Amerika Serikat
        };

        for (Locale locale : daftarLocale) {
            tampilkanFormattedData(locale, jumlahUang, tanggal);
            System.out.println("---");
        }

        scanner.close();
    }

    public static void tampilkanFormattedData(Locale locale, double jumlahUang, Date tanggal) {

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        Currency currency = currencyFormat.getCurrency();

        String formattedCurrency = currencyFormat.format(jumlahUang);

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(tanggal);

        System.out.println("\n=== Locale: " + locale.toString() + " ===");
        System.out.println("Country: " + locale.getDisplayCountry(locale));
        System.out.println("Currency Code: " + currency.getCurrencyCode());
        System.out.println("Currency Symbol: " + currency.getSymbol(locale));
        System.out.println("Formatted currency: " + formattedCurrency);
        System.out.println("Formatted date: " + formattedDate);
    }
}