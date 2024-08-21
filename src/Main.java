import java.util.Random;
import java.util.Scanner;
import java.time.Duration;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parkhaus parkhaus = new Parkhaus();

        while (true) {
            System.out.println("Anzahl Parkplaetze: " + parkhaus.getParkplaetze());
            System.out.println("1. Ticket ziehen und Einfahren");
            System.out.println("2. Ticket bezahlen");
            System.out.println("3. Ausfahren");
            System.out.println("4. Ein Stockwerk nach oben fahren");
            System.out.println("5. Ein Stockwerk nach unten fahren");
            System.out.println("6. Programm beenden");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    parkhaus.einfahren();
                    break;
                case "2":
                    parkhaus.bezahlen();
                    break;
                case "3":
                    parkhaus.ausfahren();
                    break;
                case "4":
                    parkhaus.obenfahren();
                    break;
                case "5":
                    parkhaus.untenfahren();
                    break;
                case "6":
                    System.out.println("Programm beendet.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Das ist nicht eine gültige Option!");
            }
        }
    }

    public static class Ticket {
        private double minutenpreis = 2;
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
        //Berechnet die Zeit zwischen Zwei punkten und rechnet mit der Variable minutenpreis
        public double preisrechner() {
            if (endZeit == null) {
                endZeit = LocalDateTime.now();
            }
            Duration duration = Duration.between(startZeit, endZeit);
            long minuten = (long) Math.ceil(duration.toMinutes());
            return minuten * minutenpreis;
        }
    }

    public static class Parkhaus {
        Random random = new Random();
        private int stockwerke = 2;
        private int aktuellerstockwerk = 0;
        // Zufällige Anzahl an Parkplätze
        private int parkplaetze = random.nextInt(0, 19) + 1;
        private Ticket ticket;

        public void einfahren() {
            if (parkplaetze > 0) {
                if (ticket == null) {
                    ticket = new Ticket();
                    setParkplaetze(parkplaetze - 1);
                    System.out.println("Sie dürfen einfahren.");
                } else {
                    System.out.println("Sie haben ein Ticket bereits bezogen!");
                }
            } else {
                System.out.println("Es sind keine Parkplätze mehr frei!");
            }
        }

        public void bezahlen() {
            if (ticket != null && !ticket.isBezahlt()) {
                double endpreis = ticket.preisrechner();
                System.out.println("Ticket bezahlt! Der Betrag beträgt: CHF " + endpreis + ".");
                ticket.setBezahlt(true);
            } else {
                System.out.println("Sie haben noch kein Ticket oder Ihr Ticket bereits bezahlt!");
            }
        }


        public void ausfahren() {
            if (ticket != null) {
                if (aktuellerstockwerk == 0 && ticket.isBezahlt()) {
                    System.out.println("Sie dürfen ausfahren.");
                    ticket = null;
                    setParkplaetze(parkplaetze + 1);
                } else if (aktuellerstockwerk > 0) {
                    System.out.println("Sie können nur im Erdgeschoss ausfahren.");
                } else {
                    System.out.println("Sie haben noch nicht bezahlt!");
                }
            } else {
                System.out.println("Sie haben kein Ticket bezogen oder sind schon ausgefahren!");
            }
        }
        //Stockwerke
        public void obenfahren() {
            if (ticket != null) {
                if (aktuellerstockwerk >= 0 && aktuellerstockwerk <= stockwerke) {
                    aktuellerstockwerk++;
                    System.out.println("Sie sind jetzt im " + aktuellerstockwerk + ". Stock.");
                } else {
                    System.out.println("Es gibt keine weiteren Stockwerke!");
                }
            } else {
                System.out.println("Sie müssen zuerst ein Ticket einlösen!");
            }
        }

        public void untenfahren() {
            if (ticket != null) {
                if (aktuellerstockwerk > 0) {
                    aktuellerstockwerk--;
                    System.out.println("Sie sind jetzt im " + aktuellerstockwerk + ". Stock.");
                } else {
                    System.out.println("Es gibt keine weiteren Stockwerke!");
                }
            } else {
                System.out.println("Sie müssen zuerst ein Ticket einlösen!");
            }
        }

        public int getParkplaetze() {
            return parkplaetze;
        }

        public void setParkplaetze(int parkplaetze) {
            this.parkplaetze = parkplaetze;
        }
    }
}
