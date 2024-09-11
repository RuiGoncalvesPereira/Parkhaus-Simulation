//Erstellt von: Rui Goncalves Pereira

import java.util.Optional;

public class Parkplaetze {
    private int freiePlaetze;

    public Parkplaetze(int freiePlaetze) {
        this.freiePlaetze = freiePlaetze;
    }

    public int getFreiePlaetze() {
        return freiePlaetze;
    }

    public void parken() {
        // Prüft, ob es freie Parkplätze gibt (freiePlaetze > 0).
        Optional.of(freiePlaetze)
                .filter(freie -> freie > 0)
                .ifPresent(freie -> {
                    freiePlaetze = freie - 1;
                    System.out.println("Ein Fahrzeug hat geparkt. Verfügbare Parkplaetze: " + freiePlaetze);
                });
    }

    public void verlassen() {
        freiePlaetze++;
        System.out.println("Ein Fahrzeug hat das Parkhaus verlassen. Verfügbare Parkplaetze: " + freiePlaetze);
    }
}
