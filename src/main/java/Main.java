public class Main {
    public static void main(String[] args) {
        AusgabeSchnittstelle ausgabe = new KonsolenAusgabe();
        Parkhaus parkhaus = new Parkhaus(ausgabe);
        parkhaus.simulationStarten();
    }
}
