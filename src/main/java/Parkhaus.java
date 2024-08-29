//Erstellt von: Rui Goncalves Pereira

import java.util.Scanner;


public class Parkhaus {
    private Parkplaetze parkplaetze;
    private TicketAutomat ticketAutomat;
    private Schranke schranke;
    private Stockwerke stockwerke;
    private ParkhausDisplay display;
    private Ticket ticket;

    public Parkhaus() {
        this.parkplaetze = new Parkplaetze(20);  // 20 Parkplaetze
        this.ticketAutomat = new TicketAutomat();
        this.schranke = new Schranke();
        this.stockwerke = new Stockwerke(3); // Parkhaus mit 3 Stockwerken
        this.display = new ParkhausDisplay(parkplaetze);
        this.ticket = null;
    }

    public void simulationStarten() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            display.anzeigen();
            System.out.println("1. Ticket ziehen und Einfahren");
            System.out.println("2. Ticket bezahlen");
            System.out.println("3. Ausfahren");
            System.out.println("4. Stockwerk wechseln");
            System.out.println("5. Programm beenden");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    einfahren();
                    break;
                case "2":
                    ticketAutomat.bezahlen(ticket);
                    break;
                case "3":
                    ausfahren();
                    break;
                case "4":
                    stockwerkFahren(scanner);
                    break;
                case "5":
                    System.out.println("Programm beendet.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Das ist keine gueltige Option!");
                    break;
            }
        }
    }

    public void einfahren() {
        if (parkplaetze.hatFreiePlaetze() && ticket == null) {
            ticket = new Ticket();
            schranke.einfahren();
            parkplaetze.belegtePlaetze();
            System.out.println("Sie sind eingefahren.");
        } else if (ticket != null) {
            System.out.println("Sie haben bereits ein Ticket!");
        } else {
            System.out.println("Keine freie Parkplaetze verfuegbar.");
        }
    }

    public void ausfahren() {
        if (ticket != null && ticket.isBezahlt()) {
            schranke.ausfahren();
            parkplaetze.freiePlaetze();
            System.out.println("Sie haben das Parkhaus verlassen.");
            ticket = null; // Ticket zurücksetzen
        } else {
            System.out.println("Sie muessen zuerst bezahlen oder ein Ticket ziehen.");
        }
    }

    public void stockwerkFahren(Scanner scanner) {
        if (ticket != null) {
            System.out.println("1. Stockwerk nach oben");
            System.out.println("2. Stockwerk nach unten");
            String richtung = scanner.nextLine();
            stockwerke.fahren(richtung);
        } else {
            System.out.println("Sie muessen zuerst ein Ticket ziehen.");
        }
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Parkplaetze getParkplaetze() {
        return parkplaetze;
    }
}
