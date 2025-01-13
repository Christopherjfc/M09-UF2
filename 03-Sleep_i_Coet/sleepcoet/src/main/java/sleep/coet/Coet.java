package sleep.coet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Coet {
    public static void main(String[] args) {
        
        ArrayList<Motor> listaMotores = new ArrayList<>();
        arranca(listaMotores);

        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.print("Número: ");
                int potObjectiu = Integer.parseInt(entrada.readLine()); // indica la potencia que se desea alcanzar
                
                if (passaAPotencia(potObjectiu)) {
                    for (Motor motor : listaMotores) {
                        motor.setPotencia(potObjectiu);
                    }
                } else {
                    System.out.println("\nIntroduce un numero entre 0 y 10 (los 2 números incluidos)\n");
                }
            }

        }catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static boolean passaAPotencia(int potencia) {
        return potencia >=0 && potencia <= 10;
    }

    public static void arranca(ArrayList<Motor> lista) {
        for (int i = 0; i < 4; i++) {
            Motor motor = new Motor(i);
            lista.add(motor);
            motor.start();
        }
    }

}


