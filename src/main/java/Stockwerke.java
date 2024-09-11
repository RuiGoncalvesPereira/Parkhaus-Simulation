//Erstellt von: Rui Goncalves Pereira

public class Stockwerke {
    private int anzahlStockwerke;
    private int aktuellerStockwerk;

    public Stockwerke(int anzahlStockwerke) {
        this.anzahlStockwerke = anzahlStockwerke;
        this.aktuellerStockwerk = 0;
    }

    // Fährt nach oben, wenn es noch ein höheres Stockwerk gibt
    public void hochfahren() {
        if (aktuellerStockwerk < anzahlStockwerke - 1) {
            aktuellerStockwerk++;
            System.out.println("Sie sind im: " + aktuellerStockwerk +" Stockwerk." );
        } else {
            System.out.println("Kein weiteres Stockwerk!");
        }
    }

    // Fährt nach unten, wenn es noch ein tieferes Stockwerk gibt
    public void runterfahren() {
        if (aktuellerStockwerk > 0) {
            aktuellerStockwerk--;
            System.out.println("Sie sind im: " + aktuellerStockwerk + " Stockwerk.");
        } else {
            System.out.println("Kein weiteres Stockwerk!");
        }
    }

    public int getAktuellerStockwerk() {
        return aktuellerStockwerk;
    }
}
