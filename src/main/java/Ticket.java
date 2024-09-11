import java.time.Duration;
import java.time.LocalDateTime;

public class Ticket {
    private double minutenpreis = 2;  // Preis pro Minute
    private boolean bezahlt = false;
    private LocalDateTime startZeit;
    private LocalDateTime endZeit;

    public Ticket() {
        this.startZeit = LocalDateTime.now();
    }

    public boolean isBezahlt() {
        return bezahlt;
    }

    public void setBezahlt(boolean bezahlt) {
        this.bezahlt = bezahlt;
        if (bezahlt) {
            this.endZeit = LocalDateTime.now();
        }
    }

    public double preisrechner() {
        if (endZeit == null) {
            endZeit = LocalDateTime.now();
        }
        Duration duration = Duration.between(startZeit, endZeit);
        long minuten = (long) Math.ceil(duration.toMinutes());
        return minuten * minutenpreis;
    }
}
