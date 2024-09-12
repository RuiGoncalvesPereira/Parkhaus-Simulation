public class EinfahrtSchranke extends Schranke {
    private AusgabeSchnittstelle ausgabeSchnittstelle;

    public EinfahrtSchranke(AusgabeSchnittstelle ausgabeSchnittstelle) {
        this.ausgabeSchnittstelle = ausgabeSchnittstelle;
    }

    @Override
    public void oeffnen() {
        ausgabeSchnittstelle.nachrichtAnzeigen("Einfahrtsschranke oeffnet sich. Sie koennen einfahren.");
    }

    @Override
    public void schliessen() {
        ausgabeSchnittstelle.nachrichtAnzeigen("Einfahrtsschranke schliesst sich.");
    }
}
