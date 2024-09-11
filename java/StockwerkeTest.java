import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StockwerkeTest {
    private Stockwerke stockwerke;

    @BeforeEach
    public void Stockwerke(){
        stockwerke = new Stockwerke(3); //3 Stockwerke (0 = Erdgeschoss)
    }

    // Testet ob man richtig die Stockwerke fährt
    @Test
    public void testStockwerkFahren(){
        stockwerke.fahren("1");
        assertEquals(1, stockwerke.getAktuellerStockwerk());
    }

}