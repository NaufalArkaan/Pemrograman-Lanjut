public class OrderItem {
    private final MenuItem menu;
    private final int jumlah;

    public OrderItem(MenuItem menu, int jumlah) {
        this.menu = menu;
        this.jumlah = jumlah;
    }

    public double getSubtotal() {
        return menu.getHarga() * jumlah;
    }

    public String toString() {
        return String.format("%-20s x%d\tRp %.2f", menu.getNama(), jumlah, getSubtotal());
    }
}
