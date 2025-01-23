package christopher.sincronitzacio;

public class Associacio {
    private final int NUMSOCIS;
    private Soci[] socis;

    public Associacio(){
        NUMSOCIS = 1000;
        socis = new Soci[NUMSOCIS];
        for (int i = 0; i < NUMSOCIS; i++) {
            socis[i] = new Soci("soci "+i ); 
        }
    }

    public void iniciaCompteTempsSocis(){
        for (Soci soci : socis) {
            soci.start();
        }
    }

    public void esperaPeriodeSocis() throws InterruptedException{
        for (Soci soci : socis) {
            soci.join();
        }
    }

    public void mostraBalancComptes(){
        System.out.println("Saldo: " + socis[0].getCompte().getSaldo());
    }

    public static void main(String[] args) throws InterruptedException {
        Associacio associacio = new Associacio();
        associacio.iniciaCompteTempsSocis();
        associacio.esperaPeriodeSocis();
        associacio.mostraBalancComptes();
    }
}