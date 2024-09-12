public class Parkplaetze {
    private int freiePlaetze;
    private AusgabeSchnittstelle ausgabeSchnittstelle;

    public Parkplaetze(int freiePlaetze, AusgabeSchnittstelle ausgabeSchnittstelle) {
        this.freiePlaetze = freiePlaetze;
        this.ausgabeSchnittstelle = ausgabeSchnittstelle;
    }

    public int getFreiePlaetze() {
        return freiePlaetze;
    }

    public void parkieren() {
        if (freiePlaetze > 0) {
            freiePlaetze -= 1;
            ausgabeSchnittstelle.nachrichtAnzeigen("Ein Fahrzeug hat geparkt. Verfuegbare Parkplaetze: " + freiePlaetze);
        } else {
            ausgabeSchnittstelle.nachrichtAnzeigen("Keine freien Parkplaetze verfuegbar.");
        }
    }

    public void verlassen() {
        freiePlaetze += 1;
        ausgabeSchnittstelle.nachrichtAnzeigen("Ein Fahrzeug hat das Parkhaus verlassen. Verfuegbare Parkplaetze: " + freiePlaetze);
    }
}
