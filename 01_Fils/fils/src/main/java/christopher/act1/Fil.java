package christopher.act1;

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
    }
}
