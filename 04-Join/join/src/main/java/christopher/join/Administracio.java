package christopher.join;

public class Administracio {
    private final static int NUM_POBLACIO_ACTIVA = 50;
    private Traballador[] poblacio_activa = new Traballador[NUM_POBLACIO_ACTIVA]; // inicializa el array con 50 espacios libres
    
    public Administracio() {
        for (int i = 0; i < NUM_POBLACIO_ACTIVA; i++) {
            poblacio_activa[i] = new Traballador("Ciutadà-" + i , 25000, 20, 65); // llena el array de intancias de Traballador
        }
    }

    public void inicaHilos() {
        for (Traballador traballador : poblacio_activa) {
            traballador.start();
        }
    }
    
    public void esperaHilos() throws InterruptedException{
        for (Traballador traballador : poblacio_activa) {
            traballador.join();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Administracio administracio = new Administracio();
        administracio.inicaHilos();
        administracio.esperaHilos();
        for (Traballador traballador : administracio.poblacio_activa) {
            System.out.printf("%s -> edat: %d Total: %.2f%n", traballador.getName(), traballador.getEdat_actual(), traballador.getCobrat());
        }
        
    }

}