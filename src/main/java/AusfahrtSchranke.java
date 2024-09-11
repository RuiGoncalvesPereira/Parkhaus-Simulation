//Erstellt von: Rui Goncalves Pereira

public class AusfahrtSchranke extends Schranke {

    @Override
    public void oeffnen() {
        Runnable oeffnen = () -> System.out.println("Ausfahrtsschranke oeffnet sich. Sie koennen ausfahren.");
        oeffnen.run();  //Führt das oberere aus
    }

    @Override
    public void schliessen() {
        Runnable schliessen = () -> System.out.println("Ausfahrtsschranke schliesst sich.");
        schliessen.run();
    }
}
