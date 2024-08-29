//Erstellt von: Rui Goncalves Pereira

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ParkhausTest {
    private Parkhaus parkhaus;

    @BeforeEach
    public void ParkhausObjekt(){
        parkhaus = new Parkhaus();
    }
    @Test
    //Testet, ob ein Ticket eingelöst wurde und ein Parkplatz genommen wird
    public void testEinfahren() {
        parkhaus.einfahren();
        assertNotNull(parkhaus.getTicket());
        assertEquals(19, parkhaus.getParkplaetze().getFreiePlaetze());
    }


    // Prüft ob ein Ticket bezahlt wurde beim Ausfahren
    @Test
    public void testAusfahren(){
        parkhaus.einfahren();
        Ticket ticket = parkhaus.getTicket();
        ticket.setBezahlt(true);
        parkhaus.ausfahren();
        assertNull(parkhaus.getTicket());
        assertEquals(20, parkhaus.getParkplaetze().getFreiePlaetze());
    }

    // Stockwerkfahren ohne ein Ticket gezogen zu haben
    @Test
    public void testStockwerk(){
        parkhaus.stockwerkFahren(new Scanner("1"));
        assertNull(parkhaus.getTicket());
    }

}