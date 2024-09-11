public class EinfahrtSchranke extends Schranke {

    @Override
    public void oeffnen() {
        Runnable oeffnen = () -> System.out.println("Einfahrtsschranke oeffnet sich. Sie koennen einfahren.");
        oeffnen.run();  //Führt das obere aus
    }

    @Override
    public void schliessen() {
        Runnable schliessen = () -> System.out.println("Einfahrtsschranke schliesst sich.");
        schliessen.run();
    }
}
