package christopher.sincronitzacio;

import java.util.Random;

public class Soci extends Thread{
    private float aportacio;
    private int esperaMax;
    private Random rnd;
    private int maxAnys;
    private Compte compte;
    
    public Soci(String nombre){
        super(nombre);
        aportacio = 10f;
        esperaMax = 10;
        rnd = new Random();
        maxAnys = 10;
        compte = Compte.getInstance();
    }

    @Override
    public void run() {
        synchronized(this){
            int interval = rnd.nextInt(esperaMax);
            float saldoCompte = compte.getSaldo();
            for (int i = 0; i < maxAnys; i++) {
                for (int j = 0; j < 12; j++) {
                    try {
                        if (j % 2 == 0) {
                            saldoCompte += aportacio;
                            compte.setSaldo(saldoCompte);
                            sleep(interval);
                        }else {
                            saldoCompte -= aportacio;
                            compte.setSaldo(saldoCompte);
                            sleep(interval);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public Compte getCompte() {
        return compte;
    }
}
