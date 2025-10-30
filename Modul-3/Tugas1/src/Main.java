import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Daftar menu
        MenuItem[] menu = {
                new MenuItem("Nasi Goreng Spesial", 25000),
                new MenuItem("Mie Ayam", 20000),
                new MenuItem("Sate Ayam", 30000),
                new MenuItem("Ayam Geprek", 22000),
                new MenuItem("Teh Manis", 7000),
                new MenuItem("Jus Alpukat", 12000)
        };

        RestaurantOrder order = new RestaurantOrder();

        System.out.println("=== Selamat Datang di Restoran Java ===\n");
        System.out.println("Daftar Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.printf("%d. %-20s Rp %.2f\n", i + 1, menu[i].getNama(), menu[i].getHarga());
        }

        boolean lanjut = true;
        while (lanjut) {
            System.out.print("\nPilih nomor menu: ");
            int pilihan = sc.nextInt();
            if (pilihan < 1 || pilihan > menu.length) {
                System.out.println("Pilihan tidak valid!");
                continue;
            }

            System.out.print("Jumlah pesanan: ");
            int jumlah = sc.nextInt();

            order.tambahPesanan(new OrderItem(menu[pilihan - 1], jumlah));

            System.out.print("Tambah pesanan lagi? (y/n): ");
            lanjut = sc.next().equalsIgnoreCase("y");
        }

        order.cetakNota();
        sc.close();
    }
}
