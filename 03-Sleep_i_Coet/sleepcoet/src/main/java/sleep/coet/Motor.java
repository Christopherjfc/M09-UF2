package sleep.coet;


public class Motor extends Thread{
    private int potenciaActual = 0;
    private int potenciaObjectiu = 0;
    private int motor;

    public Motor(int numero){
        motor = numero;
    }

    @Override
    public void run() {
        while (true) {
            if (potenciaActual < potenciaObjectiu) {
                potenciaActual++;
                System.out.printf("Motor %d: %s. Objectiu: %d Actual: %d%n",motor, (potenciaActual == potenciaObjectiu) ? "ResFer" : "Incre", potenciaObjectiu, potenciaActual);
            } else if (potenciaActual > potenciaObjectiu){
                potenciaActual--;
                System.out.printf("Motor %d: %s. Objectiu: %d Actual: %d%n",motor, (potenciaActual == potenciaObjectiu) ? "ResFer" : "Decre", potenciaObjectiu, potenciaActual);
            } else {
                System.out.printf("Motor %d: ResFer. Objectiu: %d Actual: %d%n", motor, potenciaObjectiu, potenciaActual);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setPotencia (int potencia) {
        potenciaObjectiu = potencia;
    }
}
