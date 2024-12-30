package christopher.futbol;

public class MainDemoFil {
    public static void main(String[] args) {
        Thread hiloMain = Thread.currentThread();
        
        String[] futbolistas = {
            "Piqué","Vinicius","Torres","Ramos","Ronaldo",
            "Lewan","Belli","Arnau","Aspas","Messi","Mbappé"};
        System.out.println("MainDemoFil.main:");
        for (String nombres : futbolistas) {
            Futbolista fut = new Futbolista(nombres);
            System.out.println("Prioritat  -> " + fut.getPriority() + ", -> " + hiloMain.getName());
            System.out.println("toString() -> " + fut.toString());
        }
    }
}
