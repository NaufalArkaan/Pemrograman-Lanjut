import Modul1.tugas3.TicketInfo;

public class MainApp {
    public static void main(String[] args) {
        TaxiTicket ticket = new TaxiTicket(new TicketInfo("Alice", "Downtown", 50.0, "Airport"), 30.0, 60.0);

        ticket.detailedInfo();

        ticket.checkStatus();

        ticket.displayRoute();
        ticket.displayEstimatedDuration();

        ticket.sLowDown(20);
        ticket.speedUp(15);
    }
}
