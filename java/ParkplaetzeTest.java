import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkplaetzeTest {
    private Parkplaetze parkplaetze;

    @BeforeEach
    public void ParkhausObjekt(){
        parkplaetze = new Parkplaetze(20);
    }

    @Test
    //Testet ob die Parkplaetze richtig erstellt werden
    public void testFreiePlaetze(){
        assertEquals(20, parkplaetze.getFreiePlaetze());
        assertTrue(parkplaetze.hatFreiePlaetze());
    }

    @Test
    //Besetzt ein Parkplatz und nimmt einen Platz weg
    public void testParkieren(){
        parkplaetze.belegtePlaetze();
        assertEquals(19, parkplaetze.getFreiePlaetze());
        assertNotEquals(20, parkplaetze.getFreiePlaetze());
    }

    @Test
    //Schaut ob die belegten Plätze richtig freigegeben werden.
    public void testAusparkieren(){
        parkplaetze.belegtePlaetze();
        parkplaetze.freiePlaetze();
        assertEquals(20, parkplaetze.getFreiePlaetze());
        assertTrue(parkplaetze.hatFreiePlaetze());
    }

    @Test
    //Alle Parkplaetze werden belegt
    public void testKeinePlaetze(){
        for (int i = 0; i < 20; i++) {
            parkplaetze.belegtePlaetze();  // Occupy all spaces
        }
        assertFalse(parkplaetze.hatFreiePlaetze(), "Keine plaetze mehr");

        //Schauen, ob es noch ein Platz gibt
        parkplaetze.belegtePlaetze();
        assertEquals(0, parkplaetze.getFreiePlaetze());
    }

    @Test
    //Befreit ein Parkplatz
    public void testParkplaetzeBefreien(){
        parkplaetze.freiePlaetze();
        assertEquals(20, parkplaetze.getFreiePlaetze());
        assertTrue(parkplaetze.hatFreiePlaetze());
    }







}