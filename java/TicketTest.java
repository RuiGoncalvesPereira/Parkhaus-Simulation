//Erstellt von: Rui Goncalves Pereira

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

public class TicketTest {

    @Test
    //Prüft ob der Preis korrekt berechnet wird, indem man in den ticket Konstruktor die Parameter der Zeiten einsetzt und einen Preis erwartet
    public void testPreisrechner() {
        LocalDateTime startZeit = LocalDateTime.of(2024, 8, 28, 10, 0);  // Startet um 10 Uhr morgens
        LocalDateTime endZeit = LocalDateTime.of(2024, 8, 28, 12, 0);    // Endet Mittags
        Ticket ticket = new Ticket(startZeit, endZeit);
        double preis = ticket.preisrechner();
        assertEquals(240, preis);  // Erwartet CHF 240 als Preis: ( 60min * 2 = 120min * 2 CHF/min = CHF 240)
    }

    @Test
    //Prüft, ob ein Ticket bezahlt wurde
    public void testSetBezahlt() {
        Ticket ticket = new Ticket();
        ticket.setBezahlt(true);
        assertTrue(ticket.isBezahlt());
    }
}
