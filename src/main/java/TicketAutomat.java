//Erstellt von: Rui Goncalves Pereira

import java.util.Optional;

public class TicketAutomat {

    public void bezahlen(Ticket ticket) {
        //Prüft ob das Ticket vorhanden und schon bezahlt ist
        Optional.ofNullable(ticket)
                .filter(t -> !t.isBezahlt())
                .ifPresentOrElse(t -> {
                    double endpreis = t.preisrechner();
                    System.out.println("Ticket bezahlt! Der Betrag betraegt: CHF " + endpreis + ".");
                    t.setBezahlt(true);
                }, () -> System.out.println("Das Ticket wurde bereits bezahlt!"));
    }

    public Ticket ticketZiehen() {
        return new Ticket();
    }
}
