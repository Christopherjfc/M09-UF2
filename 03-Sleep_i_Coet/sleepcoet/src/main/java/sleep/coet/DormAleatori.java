package sleep.coet;

import java.util.Random;

public class DormAleatori extends Thread{
    private long tiempoCreación;

    public DormAleatori(String nombre){
        super(nombre);// enviando el nombre al constructor de Thread para luego obtenerlo con su método "getName()"
        this.tiempoCreación = System.currentTimeMillis(); // tiempo de creación de la instáncia 
    }

    @Override
    public void run() {
        Random random = new Random();
        int milisRandom; // intervalo aleatorio de tiempo
        long tiempoActual;
        try{
            for (int i = 0; i < 10; i++) {
                milisRandom = random.nextInt(1000); // por cada iteración se le da un numero de 1 a 1000 a la variable gracias a la clase random y su métod
                tiempoActual = System.currentTimeMillis();
                System.out.printf("%s (%d) a dormir a %dms total %d%n", getName(), i, milisRandom, tiempoActual - tiempoCreación);// esta resta es el intervalo de tiempo del System.currentTimeMillis() 
                Thread.sleep(milisRandom); // los hilos se dormiran el intervalo de tiempo de 1 a 1000mls
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}