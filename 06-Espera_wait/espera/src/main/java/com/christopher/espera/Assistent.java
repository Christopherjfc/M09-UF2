package com.christopher.espera;

import java.util.Random;

public class Assistent extends Thread {
    private Esdeveniment esdeveniment;
    private final float PROBABILITAT = 0.5f;
    private Random rnd;

    public Assistent(String name, Esdeveniment esdeveniment) {
        super(name);
        this.esdeveniment = esdeveniment;
        rnd = new Random();
    }

    @Override
    public void run() {
        int intervalo;
        while (true) {
            if (Math.random() <= PROBABILITAT) {
                try {
                    if (!esdeveniment.ferReserva(this)) {
                        wait();
                        intervalo = rnd.nextInt(1000);
                    } else {
                        System.out.printf("%s ha fet una reserva. Places disponibles: %d", getName(), esdeveniment.getPlacesDisponibles());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                if (esdeveniment.cancelaReserva(this)) {
                    notifyAll();
                    intervalo = rnd.nextInt(1000);
                } else {
                    System.out.printf("%s no ha pogut cancel·lar una reserva inexistent. Places disponibles: %d", getName(), esdeveniment.getPlacesDisponibles());
                }
            }
        }
    }
}
