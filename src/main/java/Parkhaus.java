//Erstellt von: Rui Goncalves Pereira

import java.util.Scanner;

public class Parkhaus {
    private Parkplaetze parkplaetze;
    private TicketAutomat ticketAutomat;
    private Stockwerke stockwerke;
    private ParkhausDisplay display;
    private Ticket ticket;
    private EinfahrtSchranke einfahrtSchranke;
    private AusfahrtSchranke ausfahrtSchranke;
    private boolean imParkhaus = false;  // Prüft, ob das Auto im Parkhaus ist

    public Parkhaus() {
        this.parkplaetze = new Parkplaetze(20);  // 20 Parkplaetze
        this.ticketAutomat = new TicketAutomat();
        this.einfahrtSchranke = new EinfahrtSchranke();
        this.ausfahrtSchranke = new AusfahrtSchranke();
        this.stockwerke = new Stockwerke(3);  // Parkhaus mit 3 Stockwerken
        this.display = new ParkhausDisplay(parkplaetze);
        this.ticket = null;
    }

    public void simulationStarten() {
        Scanner scanner = new Scanner(System.in);
        boolean continueSimulation = true;

        while (continueSimulation) {
            display.anzeigen();
            System.out.println("1. Ticket ziehen und Einfahren");
            System.out.println("2. Ticket bezahlen");
            System.out.println("3. Parkhaus verlassen");
            System.out.println("4. Stockwerk wechseln");
            System.out.println("5. Simulation beenden");
            System.out.print("Waehlen Sie eine Option: ");

            int auswahl = scanner.nextInt();

            switch (auswahl) {
                case 1 -> {
                    if (!imParkhaus) {
                        ticket = ticketAutomat.ticketZiehen();
                        einfahrtSchranke.oeffnen();
                        parkplaetze.parken();
                        einfahrtSchranke.schliessen();
                        imParkhaus = true;
                    } else {
                        System.out.println("Sie sind bereits im Parkhaus!");
                    }
                }
                case 2 -> {
                    if (ticket != null && imParkhaus) {
                        ticketAutomat.bezahlen(ticket);
                    } else {
                        System.out.println("Sie muessen zuerst einfahren, bevor Sie bezahlen können!");
                    }
                }
                case 3 -> {
                    if (imParkhaus) {
                        if (ticket != null && ticket.isBezahlt()) {
                            ausfahrtSchranke.oeffnen();
                            parkplaetze.verlassen();
                            ausfahrtSchranke.schliessen();
                            ticket = null;  // Ticket zurücksetzen
                            imParkhaus = false;
                        } else {
                            System.out.println("Sie koennen das Parkhaus nicht verlassen, ohne zu bezahlen!");
                        }
                    } else {
                        System.out.println("Sie sind nicht im Parkhaus!");
                    }
                }
                case 4 -> {
                    if (imParkhaus) {
                        System.out.println("1. Hochfahren");
                        System.out.println("2. Runterfahren");
                        int stockwerkWahl = scanner.nextInt();
                        if (stockwerkWahl == 1) {
                            stockwerke.hochfahren();
                        } else if (stockwerkWahl == 2) {
                            stockwerke.runterfahren();
                        } else {
                            System.out.println("Ungueltige Option!");
                        }
                    } else {
                        System.out.println("Sie muessen zuerst einfahren, um das Stockwerk zu wechseln!");
                    }
                }
                case 5 -> {
                    continueSimulation = false;
                    System.out.println("Simulation beendet.");
                }
                default -> System.out.println("Ungueltige Option!");
            }
        }
    }
}
