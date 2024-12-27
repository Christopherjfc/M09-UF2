package christopher.act1;

/*
 * Clase Fil (Hilo) que hereda Thread
 */

public class Fil extends Thread{
    String nombre;

    public Fil(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(nombre + " " + i);
        }
        System.out.println("Termina el fil Juan " + nombre);
    }
}
