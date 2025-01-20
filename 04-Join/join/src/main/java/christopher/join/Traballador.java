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

    @Override
    public void run() {
        int intervalo = rnd.nextInt(10);
        for (edat_actual = edat_inici_treball; edat_actual < edat_fi_treball; edat_actual++) {
            for (int j = 0; j < 12; j++) {
                try {
                    cobra();
                    sleep(intervalo);
                    pagaImpostos();
                    sleep(intervalo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void cobra() {
        cobrat += nou_anual_brut / 12f; // salario mensual bruto
    }

    public void pagaImpostos() {
        cobrat -= (nou_anual_brut / 12f) * 0.24f; // Resta el 24% de impuestos al salario para que el salario mensual sea neto
    }

    public int getEdat_actual() {
        return edat_actual;
    }

    public float getCobrat() {
        return cobrat;
    }
}
