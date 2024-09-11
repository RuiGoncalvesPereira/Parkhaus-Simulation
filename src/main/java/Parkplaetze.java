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
        // Optional with lambda to check and reduce freiePlaetze
        Optional.of(freiePlaetze)
                .filter(freie -> freie > 0)
                .ifPresent(freie -> {
                    freiePlaetze = freie - 1;
                    System.out.println("Ein Fahrzeug hat geparkt. Verfügbare Parkplätze: " + freiePlaetze);
                });
    }

    public void verlassen() {
        freiePlaetze++;
        System.out.println("Ein Fahrzeug hat das Parkhaus verlassen. Verfügbare Parkplätze: " + freiePlaetze);
    }
}
