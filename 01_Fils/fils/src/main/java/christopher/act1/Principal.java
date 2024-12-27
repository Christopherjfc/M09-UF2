package christopher.act1;

/*
 * Clase Main
 */

public class Principal {
    public static void main(String[] args) {
        System.out.println("Termina thread main");
        Fil juan = new Fil("Juan");
        Fil pepe = new Fil("Pepe");
        pepe.start();
        juan.start(); 
    }
}