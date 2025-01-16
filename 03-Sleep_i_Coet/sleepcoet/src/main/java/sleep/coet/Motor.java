package sleep.coet;

public class Motor extends Thread{
    private int potenciaActual = 0;
    private static int potenciaObjectiu = 0; // al ser static, el cambio de esta potencia afectará a todos los motores
    private int motor; // numero de motor

    public Motor(int numero){
        motor = numero; // asigna el numero del motor creado
    }

    @Override
    public void run() {
        while (true) {
            // entra al bucle si la potencia que se pasó por consola no es 0
            while (potenciaObjectiu != 0) {
                if (potenciaActual < potenciaObjectiu) {
                    potenciaActual++;
                    System.out.printf("Motor %d: %s. Objectiu: %d Actual: %d%n",motor, (potenciaActual == potenciaObjectiu) ? "ResFer" : "Incre", potenciaObjectiu, potenciaActual);
                } else if (potenciaActual > potenciaObjectiu){
                    potenciaActual--;
                    System.out.printf("Motor %d: %s. Objectiu: %d Actual: %d%n",motor, (potenciaActual == potenciaObjectiu) ? "ResFer" : "Decre", potenciaObjectiu, potenciaActual);
                } else { 
                    // cuando se igualan las potencias, los motores se esperarán hasta que se introduzca una nueva potencia por consola
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    // los motores se esperan 1s por cada incremento o decremento de potencia
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
 
            if(potenciaObjectiu == 0){
                potenciaActual--;
                System.out.printf("Motor %d: %s. Objectiu: %d Actual: %d%n",motor, (potenciaActual == potenciaObjectiu) ? "ResFer" : "Decre", potenciaObjectiu, potenciaActual);
                if (potenciaActual == 0) break;
                try {
                    Thread.sleep(100);
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
}
