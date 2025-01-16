package sleep.coet;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Coet {
    public static void main(String[] args) {
       
        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in))) { // toma datos por consola 
            ArrayList<Motor> listaMotores = new ArrayList<>(); // lista que almacenará los motores
            arranca(listaMotores, entrada); // arranca los 4 motores 
            
            while (true) {
                int potObjectiu = Integer.parseInt(entrada.readLine()); // indica la potencia que se desea alcanzar por consola
                if (passaAPotencia(potObjectiu)) {
                    listaMotores.get(0).setPotencia(potObjectiu); // cambia la potencia de todos los motores
                    if (potObjectiu == 0) { 
                        break; // si la potencia que se introduce por consola es 0, se rompe el bucle.
                    }
                } else {
                    // si la potencia es erronea se imprime este texto y vuelve a esperar otro numero
                    System.out.println("\nIntroduce un numero entre 0 y 10 (los 2 números incluidos)\n");
                }
            }
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    // retorna true la potencia es mayor o igual que 0 y menor o igual que 10
    public static boolean passaAPotencia(int potencia) { 
        return potencia >=0 && potencia <= 10;
    }

    // cambia la potenciaObtjectiu de todos los motores, añade cada motor a la lista y los arranca. 
    public static void arranca(ArrayList<Motor> lista, BufferedReader entrada) throws IOException{
        for (int i = 0; i < 4; i++) {
            Motor motor = new Motor(i);
            /*
            * Como la variable potenciaObjectiu de la clase motor es staiic solo hace falta que se cambie una vez
            * para que se cambie en todos los motores. Por esa razón se hace el este "if", y mientras el número 
            * que se pide por consola sea 0, volverá a pedir un numero hasta que sea uno diferente.
            */

            if (motor.getPotenciaObjectiu() == 0) { 
                while (true) { // entra al bucle su la potenciaObjectiu del motor es 0
                    int numero = Integer.parseInt(entrada.readLine());
                    if (numero > 0 && numero <= 10) {
                        motor.setPotencia(numero); // la potencia de los motores cambia si el numero de consola no es 0
                        lista.add(motor); // se añade el motor a la lista
                        motor.start(); // inicia el hilo
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
