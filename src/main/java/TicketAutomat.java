//Erstellt von: Rui Goncalves Pereira
public class TicketAutomat {
    public void bezahlen(Ticket ticket) {
        if (ticket != null && !ticket.isBezahlt()) {
            double endpreis = ticket.preisrechner();
            System.out.println("Ticket bezahlt! Der Betrag betraegt: CHF " + endpreis + ".");
            ticket.setBezahlt(true);
        } else {
            System.out.println("Sie haben noch kein Ticket oder Ihr Ticket ist bereits bezahlt!");
        }
    }
}
