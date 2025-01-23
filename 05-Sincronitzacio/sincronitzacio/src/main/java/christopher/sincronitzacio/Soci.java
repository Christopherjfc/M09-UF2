package christopher.sincronitzacio;

import java.util.Random;

public class Soci extends Thread {
    private float aportacio;
    private int esperaMax;
    private Random rnd;
    private int maxAnys;
    private Compte compte;

    public Soci(String nombre) {
        super(nombre);
        aportacio = 10f;
        esperaMax = 10;
        rnd = new Random();
        maxAnys = 10;
        compte = Compte.getInstance(); // recupera la única instancia creada
    }

    @Override
    public void run() {
        int interval = rnd.nextInt(esperaMax);
        for (int i = 0; i < maxAnys; i++) {
            for (int j = 0; j < 12; j++) {
                try {
                    //sincronizo los hilos para que puedan esperarse de 1 en 1 sin que todos ataquen a la vez hacia la misma operación
                    if (j % 2 == 0) {
                        synchronized (compte) {
                            compte.setSaldo(compte.getSaldo() + aportacio);
                        }
                        sleep(interval);
                    } else {
                        synchronized (compte) {
                            compte.setSaldo(compte.getSaldo() - aportacio);
                        }
                        sleep(interval);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Compte getCompte() {
        return compte;
    }
}
