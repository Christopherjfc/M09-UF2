package christopher.join;

import java.util.Random;

public class Traballador extends Thread{
    private int nou_anual_brut;
    private int edat_inici_treball;
    private int edat_fi_treball;
    private int edat_actual;
    private float cobrat;
    Random rnd = new Random();

    public Traballador(String nombre) {
        super(nombre);
        nou_anual_brut = 25000;
        edat_inici_treball = 20;
        edat_fi_treball = 65;
        edat_actual = 0;
        cobrat = 0.0f;
    }

/*
 * se tiene que hacer una simulación, 
 * cada mes, cada año, hasta llegar a la edat final
 * SLEEP(100) DESPUES DE COBRAR Y PAGAR IMPUESTOS: para dejar a que carguen bien los hilos
 */

    @Override
    public void run() {
        int intervalo = rnd.nextInt(100);

        cobra();
        pagaImpostos();
        try {
            Thread.sleep(intervalo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

    public void cobra() {
        cobrat = nou_anual_brut / 12;
    }

    public void pagaImpostos() {
        cobrat = cobrat + (cobrat * 0.24f);
    }

    public int getEdat_actual() {
        return edat_actual;
    }

    public float getCobrat() {
        return cobrat;
    }
}
