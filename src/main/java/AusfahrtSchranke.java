public class AusfahrtSchranke extends Schranke {
    private AusgabeSchnittstelle ausgabeSchnittstelle;

    public AusfahrtSchranke(AusgabeSchnittstelle ausgabeSchnittstelle) {
        this.ausgabeSchnittstelle = ausgabeSchnittstelle;
    }

    @Override
    public void oeffnen() {
        ausgabeSchnittstelle.nachrichtAnzeigen("Ausfahrtsschranke oeffnet sich. Sie koennen ausfahren.");
    }

    @Override
    public void schliessen() {
        ausgabeSchnittstelle.nachrichtAnzeigen("Ausfahrtsschranke schliesst sich.");
    }
}
