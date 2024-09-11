//Erstellt von: Rui Goncalves Pereira
public class ParkhausDisplay {
    private Parkplaetze parkplaetze;

    public ParkhausDisplay(Parkplaetze parkplaetze) {
        this.parkplaetze = parkplaetze;
    }

    public void anzeigen() {
        System.out.println("Freie Parkplaetze: " + parkplaetze.getFreiePlaetze());
    }
}