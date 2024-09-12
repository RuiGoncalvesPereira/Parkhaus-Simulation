public class KonsolenAusgabe implements AusgabeSchnittstelle {
    @Override
    public void nachrichtAnzeigen(String nachricht) {
        System.out.println(nachricht);
    }
}
