package christopher.join;

public class Administracio {
    private final static int NUM_POBLACIO_ACTIVA = 50;
    private Traballador[] poblacio_activa;
    
    public Administracio() {
        poblacio_activa = new Traballador[NUM_POBLACIO_ACTIVA];
        for (int i = 0; i < NUM_POBLACIO_ACTIVA; i++) {
            poblacio_activa[i] = new Traballador("Ciutadà-" + i , 25000, 20, 65);
        }
    }

    public void inicaHilos() {
        for (Traballador traballador : poblacio_activa) {
            traballador.start();
            try {
                traballador.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Traballador traballador : poblacio_activa) {
            try {
                traballador.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Administracio administracio = new Administracio();
        administracio.inicaHilos();
    }
}