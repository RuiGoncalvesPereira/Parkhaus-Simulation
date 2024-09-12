public class TicketAutomat {
    private boolean ticketGegeben = false;
    private AusgabeSchnittstelle ausgabeSchnittstelle;

    public TicketAutomat(AusgabeSchnittstelle ausgabeSchnittstelle) {
        this.ausgabeSchnittstelle = ausgabeSchnittstelle;
    }

    public Ticket ticketZiehen() {
        if (!ticketGegeben) {
            ticketGegeben = true;
            ausgabeSchnittstelle.nachrichtAnzeigen("Ticket erfolgreich gezogen.");
            return new Ticket();
        } else {
            ausgabeSchnittstelle.nachrichtAnzeigen("Sie haben bereits ein Ticket gezogen.");
            return null;
        }
    }

    public void bezahlen(Ticket ticket) {
        if (ticket != null && !ticket.isBezahlt()) {
            double endpreis = ticket.preisrechner();
            ausgabeSchnittstelle.nachrichtAnzeigen("Ticket bezahlt! Betrag: CHF " + endpreis + ".");
            ticket.setBezahlt(true);
            ticketGegeben = false;
        } else {
            ausgabeSchnittstelle.nachrichtAnzeigen("Das Ticket wurde bereits bezahlt oder ist nicht vorhanden!");
        }
    }
}
