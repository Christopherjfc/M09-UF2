package sleep.coet;

import java.util.Random;

public class DormAleatori extends Thread{
    private long tiempoCreación;

    public DormAleatori(String nombre){
        super(nombre);
        this.tiempoCreación = System.currentTimeMillis();
    }

    @Override
    public void run() {
        Random random = new Random();
        int milisRandom;
        long tiempoActual;
        try{
            for (int i = 0; i < 10; i++) {
                milisRandom = random.nextInt(1000);
                tiempoActual = System.currentTimeMillis();
                System.out.printf("%s (%d) a dormir a %dms total %d%n", getName(), i, milisRandom, tiempoActual - tiempoCreación);// esta resta es el intervalo de tiempo del System.currentTimeMillis() 
                Thread.sleep(milisRandom);
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}