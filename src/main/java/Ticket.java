//Erstellt von: Rui Goncalves Pereira

import java.time.Duration;
import java.time.LocalDateTime;

public class Ticket {
    private double minutenpreis = 2; // Preis pro minute
    private boolean bezahlt = false;
    private LocalDateTime startZeit;
    private LocalDateTime endZeit;

    public Ticket() {
        this.startZeit = LocalDateTime.now();
    }

    public Ticket(LocalDateTime startZeit, LocalDateTime endZeit) {
        this.startZeit = startZeit;
        this.endZeit = endZeit;
    }

    public boolean isBezahlt() {
        return bezahlt;
    }

    //Setzt bezahlt auf den Standardwert false und stoppt die Zeit
    public void setBezahlt(boolean bezahlt) {
        this.bezahlt = bezahlt;
        if (bezahlt) {
            this.endZeit = LocalDateTime.now();
        }
    }

    //Rechnet den Preis indem sie die Zeit zwischen Einfahren und Ticket lösen berechnet.
    public double preisrechner() {
        if (endZeit == null) {
            endZeit = LocalDateTime.now();
        }
        Duration duration = Duration.between(startZeit, endZeit);
        long minuten = (long) Math.ceil(duration.toMinutes());
        return minuten * minutenpreis;
    }
}
