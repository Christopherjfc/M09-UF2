package christopher.join;

import java.util.Random;

public class Traballador extends Thread {
    private int nou_anual_brut;
    private int edat_inici_treball;
    private int edat_fi_treball;
    private int edat_actual;
    private float cobrat;
    private Random rnd;

    public Traballador(String nombre, int sou_anual, int edat_inici, int edat_fi) {
        super(nombre);
        nou_anual_brut = sou_anual;
        edat_inici_treball = edat_inici;
        edat_fi_treball = edat_fi;
        edat_actual = 0;
        cobrat = 0.0f;
        rnd = new Random();
    }

    /*
     * se tiene que hacer una simulación,
     * cada mes, cada año, hasta llegar a la edat final
     * SLEEP(100) DESPUES DE COBRAR Y PAGAR IMPUESTOS: para dejar a que carguen bien
     * los hilos
     */

    @Override
    public void run() {
        int intervalo = rnd.nextInt(100);
        while ((edat_actual + edat_inici_treball) != edat_fi_treball) {
            for (int i = 0; i < 12; i++) {
                cobra();
                pagaImpostos();
            }
            try {
                sleep(intervalo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            edat_actual++;
        }
        System.out.printf("%s -> edat: Total: %.2f%n", getName(), cobrat);

    }

    public void cobra() {
        cobrat += nou_anual_brut / 12; // salario mensual bruto
    }

    public void pagaImpostos() {
        cobrat -= (nou_anual_brut / 12) * 0.24f; // Resta el 24% de impuestos al salario para que el salario mensual sea
                                                 // neto
    }

    public int getEdat_actual() {
        return edat_actual;
    }

    public float getCobrat() {
        return cobrat;
    }
}
