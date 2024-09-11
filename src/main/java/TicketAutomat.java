import java.util.Optional;

public class TicketAutomat {

    public void bezahlen(Ticket ticket) {
        Optional.ofNullable(ticket)
                .filter(t -> !t.isBezahlt())
                .ifPresentOrElse(t -> {
                    double endpreis = t.preisrechner();
                    System.out.println("Ticket bezahlt! Der Betrag beträgt: CHF " + endpreis + ".");
                    t.setBezahlt(true);
                }, () -> System.out.println("Das Ticket wurde bereits bezahlt!"));
    }

    public Ticket ticketZiehen() {
        return new Ticket();
    }
}
