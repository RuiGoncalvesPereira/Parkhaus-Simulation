//Erstellt von: Rui Goncalves Pereira
public class Parkplaetze {
    private int totalPlaetze;
    private int belegtePlaetze;

    public Parkplaetze(int totalPlaetze) {
        this.totalPlaetze = totalPlaetze;
        this.belegtePlaetze = 0;
    }

    //Prüft ob es freie Plätze hat
    public boolean hatFreiePlaetze() {
        return belegtePlaetze < totalPlaetze;
    }

    //Wenn Parkplätze verfügbar sind, wird ein Platz belegt
    public void belegtePlaetze() {
        if (hatFreiePlaetze()) {
            belegtePlaetze++;
        }
    }

    //Wenn ein Parkplatz belegt ist und man zahlen will, wird der belegte Platz wieder frei.
    public void freiePlaetze() {
        if (belegtePlaetze > 0) {
            belegtePlaetze--;
        }
    }

    //Rechnet die Anzahl Parkplätze indem sie die belegten Plätzen von den totalen Plätzen subtrahiert.
    public int getFreiePlaetze() {
        return totalPlaetze - belegtePlaetze;
    }
}
