package christopher.act1;

public class Fil extends Thread{
    String nombre;
    static boolean esJuan = true;

    public Fil(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            if (nombre.equals("Juan") && esJuan) {
                System.out.println(nombre + " " + i);
                esJuan = false;
            } else if (nombre.equals("Pepe") && !esJuan) {
                System.out.println(nombre + " " + i);
                esJuan = true;
            }

            try {
                Thread.sleep(150);
            } catch (InterruptedException ie) {
                System.out.println(ie.getMessage());
            }
        }
        System.out.println("Termina el fil " + nombre);
    }
}
