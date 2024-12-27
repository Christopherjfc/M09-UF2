package christopher.act1;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Termina thread main");
        Fil juan = new Fil("Juan");
        Fil pepe = new Fil("Pepe");
        
        pepe.start();
        
        try {
            pepe.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        
        juan.start(); 
        
        try {
            juan.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Termina el fil Pepe");
        System.out.println("Termina el fil Juan");
    }
}