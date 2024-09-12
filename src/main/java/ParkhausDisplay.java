public class ParkhausDisplay {
    private Parkplaetze parkplaetze;
    private AusgabeSchnittstelle ausgabeSchnittstelle;

    public ParkhausDisplay(Parkplaetze parkplaetze, AusgabeSchnittstelle ausgabeSchnittstelle) {
        this.parkplaetze = parkplaetze;
        this.ausgabeSchnittstelle = ausgabeSchnittstelle;
    }

    public void anzeigen() {
        ausgabeSchnittstelle.nachrichtAnzeigen("Verfuegbare Parkplaetze: " + parkplaetze.getFreiePlaetze());
    }
}
