package sleep.coet;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Coet {
    public static void main(String[] args) {
       
        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayList<Motor> listaMotores = new ArrayList<>();
            arranca(listaMotores, entrada);
            
            while (true) {
                int potObjectiu = Integer.parseInt(entrada.readLine()); // indica la potencia que se desea alcanzar por consola
                if (passaAPotencia(potObjectiu)) {
                    listaMotores.get(0).setPotencia(potObjectiu);
                    if (potObjectiu == 0) {
                        break;
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


    public static void arranca(ArrayList<Motor> lista, BufferedReader entrada) throws IOException{
        for (int i = 0; i < 4; i++) {
            Motor motor = new Motor(i);
            if (motor.getPotenciaObjectiu() == 0) {
                while (true) {
                    int numero = Integer.parseInt(entrada.readLine());
                    if (numero > 0 && numero <= 10) {
                        motor.setPotencia(numero);
                        lista.add(motor);
                        motor.start();
                        break;
                    }
                }
            }else {
                lista.add(motor);
                motor.start();
            }
        }
    }
}
