import java.util.Scanner;

public class Parkhaus {
    private Parkplaetze parkplaetze;
    private TicketAutomat ticketAutomat;
    private Stockwerke stockwerke;
    private ParkhausDisplay display;
    private Ticket ticket;
    private EinfahrtSchranke einfahrtSchranke;
    private AusfahrtSchranke ausfahrtSchranke;
    private boolean imParkhaus = false;
    private AusgabeSchnittstelle ausgabeSchnittstelle;

    public Parkhaus(AusgabeSchnittstelle ausgabeSchnittstelle) {
        this.ausgabeSchnittstelle = ausgabeSchnittstelle;
        this.parkplaetze = new Parkplaetze(20, ausgabeSchnittstelle);  // 20 Parkplaetze
        this.ticketAutomat = new TicketAutomat(ausgabeSchnittstelle);
        this.einfahrtSchranke = new EinfahrtSchranke(ausgabeSchnittstelle);
        this.ausfahrtSchranke = new AusfahrtSchranke(ausgabeSchnittstelle);
        this.stockwerke = new Stockwerke(3);  // Parkhaus mit 3 Stockwerken
        this.display = new ParkhausDisplay(parkplaetze, ausgabeSchnittstelle);
        this.ticket = null;
    }

    public void simulationStarten() {
        Scanner scanner = new Scanner(System.in);
        boolean simulationFortsetzen = true;

        while (simulationFortsetzen) {
            display.anzeigen();
            ausgabeSchnittstelle.nachrichtAnzeigen("1. Ticket ziehen und einfahren");
            ausgabeSchnittstelle.nachrichtAnzeigen("2. Ticket bezahlen");
            ausgabeSchnittstelle.nachrichtAnzeigen("3. Parkhaus verlassen");
            ausgabeSchnittstelle.nachrichtAnzeigen("4. Stockwerk wechseln");
            ausgabeSchnittstelle.nachrichtAnzeigen("5. Simulation beenden");
            System.out.print("Waehlen Sie eine Option: ");

            int auswahl = scanner.nextInt();

            switch (auswahl) {
                case 1 -> {
                    if (!imParkhaus) {
                        ticket = ticketAutomat.ticketZiehen();
                        if (ticket != null) {
                            einfahrtSchranke.oeffnen();
                            parkplaetze.parkieren();
                            einfahrtSchranke.schliessen();
                            imParkhaus = true;
                        }
                    } else {
                        ausgabeSchnittstelle.nachrichtAnzeigen("Sie sind bereits im Parkhaus.");
                    }
                }
                case 2 -> {
                    if (ticket != null && imParkhaus) {
                        ticketAutomat.bezahlen(ticket);
                    } else {
                        ausgabeSchnittstelle.nachrichtAnzeigen("Sie muessen ein Ticket ziehen, um zu bezahlen!");
                    }
                }
                case 3 -> {
                    if (imParkhaus && ticket != null) {
                        if (ticket.isBezahlt()) {
                            // Nur verlassen, wenn man im Erdgeschoss ist (Stockwerk 0)
                            if (stockwerke.getAktuellesStockwerk() == 0) {
                                ausfahrtSchranke.oeffnen();
                                parkplaetze.verlassen();
                                ausfahrtSchranke.schliessen();
                                ticket = null;
                                imParkhaus = false;
                            } else {
                                ausgabeSchnittstelle.nachrichtAnzeigen("Sie muessen im Erdgeschoss (Stockwerk 0) sein, um das Parkhaus zu verlassen!");
                            }
                        } else {
                            ausgabeSchnittstelle.nachrichtAnzeigen("Sie koennen das Parkhaus nicht verlassen, ohne zu bezahlen!");
                        }
                    } else {
                        ausgabeSchnittstelle.nachrichtAnzeigen("Sie sind nicht im Parkhaus!");
                    }
                }
                case 4 -> {
                    if (imParkhaus) {
                        ausgabeSchnittstelle.nachrichtAnzeigen("1. Hochfahren");
                        ausgabeSchnittstelle.nachrichtAnzeigen("2. Runterfahren");
                        int stockwerkWahl = scanner.nextInt();
                        if (stockwerkWahl == 1) {
                            stockwerke.hochfahren();
                        } else if (stockwerkWahl == 2) {
                            stockwerke.runterfahren();
                        } else {
                            ausgabeSchnittstelle.nachrichtAnzeigen("Ungueltige Option!");
                        }
                    } else {
                        ausgabeSchnittstelle.nachrichtAnzeigen("Sie muessen zuerst einfahren, um das Stockwerk zu wechseln!");
                    }
                }
                case 5 -> {
                    simulationFortsetzen = false;
                    ausgabeSchnittstelle.nachrichtAnzeigen("Simulation beendet.");
                }
                default -> ausgabeSchnittstelle.nachrichtAnzeigen("Ungueltige Option!");
            }
        }
    }
}
