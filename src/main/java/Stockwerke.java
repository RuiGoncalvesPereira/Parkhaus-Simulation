public class Stockwerke {
    private int anzahlStockwerke;
    private int aktuellesStockwerk;

    public Stockwerke(int anzahlStockwerke) {
        this.anzahlStockwerke = anzahlStockwerke;
        this.aktuellesStockwerk = 0;
    }

    public void hochfahren() {
        if (aktuellesStockwerk < anzahlStockwerke - 1) {
            aktuellesStockwerk++;
            System.out.println("Sie sind im: " + aktuellesStockwerk + " Stockwerk.");
        } else {
            System.out.println("Kein weiteres Stockwerk!");
        }
    }

    public void runterfahren() {
        if (aktuellesStockwerk > 0) {
            aktuellesStockwerk--;
            System.out.println("Sie sind im: " + aktuellesStockwerk + " Stockwerk.");
        } else {
            System.out.println("Kein weiteres Stockwerk!");
        }
    }

    public int getAktuellesStockwerk() {
        return aktuellesStockwerk;
    }

    public int getAnzahlStockwerke() {
        return anzahlStockwerke;
    }
}
