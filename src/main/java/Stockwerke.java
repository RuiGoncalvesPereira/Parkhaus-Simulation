//Erstellt von: Rui Goncalves Pereira
public class Stockwerke {
    private int aktuellerStockwerk;
    private int maxStockwerke;

    public Stockwerke(int maxStockwerke) {
        this.aktuellerStockwerk = 0; // In diesem Fall ist 0 das Erdgeschoss
        this.maxStockwerke = maxStockwerke;
    }

    //Steigen oder absteigen
    public void fahren(String richtung) {
        if (richtung.equals("1") && aktuellerStockwerk < maxStockwerke) {
            aktuellerStockwerk++;
            System.out.println("Sie sind jetzt im " + aktuellerStockwerk + ". Stock.");
        } else if (richtung.equals("2") && aktuellerStockwerk > 0) {
            aktuellerStockwerk--;
            System.out.println("Sie sind jetzt im " + aktuellerStockwerk + ". Stock.");
        } else {
            System.out.println("Ungueltige Option oder keine weitere Stockwerke!");
        }
    }

    public int getAktuellerStockwerk() {
        return aktuellerStockwerk;
    }
}
