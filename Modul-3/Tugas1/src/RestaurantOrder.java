import java.util.ArrayList;

public class RestaurantOrder {
    private final ArrayList<OrderItem> pesanan = new ArrayList<>();

    public void tambahPesanan(OrderItem item) {
        pesanan.add(item);
    }

    public double hitungTotal() {
        double total = 0;
        for (OrderItem i : pesanan) {
            total += i.getSubtotal();
        }
        return total;
    }
    

    public double hitungDiskon(double total) {
        if (total >= 100000) return total * 0.15;// diskon 15%
        if (total >= 50000) return  total * 0.10;  // diskon 10%
        return 0;
    }

    public void cetakNota() {
        System.out.println("\n========== NOTA PEMESANAN ==========");
        for (OrderItem i : pesanan) {
            System.out.println(i);
        }
        double total = hitungTotal();
        double diskon = hitungDiskon(total);
        double bayar = total - diskon;

        System.out.println("------------------------------------");
        System.out.printf("Total\t\t\t: Rp %.2f\n", total);
        System.out.printf("Diskon\t\t\t: Rp %.2f\n", diskon);
        System.out.printf("Total Bayar\t\t: Rp %.2f\n", bayar);
        System.out.println("====================================");
        System.out.println("Terima kasih telah memesan di Restoran Kami!");
    }
}
