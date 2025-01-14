package sleep.coet;

public class Motor extends Thread{
    private int potenciaActual = 0;
    private static int potenciaObjectiu = 0;
    private int motor;
    private boolean apagado = false;


    public Motor(int numero){
        motor = numero;
    }


    @Override
    public void run() {
        while (true) {
            while (potenciaObjectiu != 0) {
                if (potenciaActual < potenciaObjectiu) {
                    potenciaActual++;
                    System.out.printf("Motor %d: %s. Objectiu: %d Actual: %d%n",motor, (potenciaActual == potenciaObjectiu) ? "ResFer" : "Incre", potenciaObjectiu, potenciaActual);
                } else if (potenciaActual > potenciaObjectiu){
                    potenciaActual--;
                    System.out.printf("Motor %d: %s. Objectiu: %d Actual: %d%n",motor, (potenciaActual == potenciaObjectiu) ? "ResFer" : "Decre", potenciaObjectiu, potenciaActual);
                } else {
                    System.out.println("Introdueix un nou numero: ");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(potenciaActual >= 0 && potenciaActual >= 0){
                if (potenciaActual != 0) potenciaActual--;
                System.out.printf("Motor %d: %s. Objectiu: %d Actual: %d%n",motor, (potenciaActual == potenciaObjectiu) ? "ResFer" : "Decre", potenciaObjectiu, potenciaActual);
                if (potenciaActual == 0){
                    apagado = true;
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void setPotencia (int potencia) {
        potenciaObjectiu = potencia;
        System.out.println("Passant a potència " + potenciaObjectiu);
    }


    public int getPotenciaObjectiu() {
        return potenciaObjectiu;
    }

    public int getPotenciaActual() {
        return potenciaActual;
    }

    public  boolean motoresApagados() {
        return apagado;
    }
}
