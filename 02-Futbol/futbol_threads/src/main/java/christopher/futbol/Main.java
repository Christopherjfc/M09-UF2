package christopher.futbol;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] futbolistas = {
            "Piqué","Vinicius","Torres","Ramos","Ronaldo",
            "Lewan","Belli","Arnau","Aspas","Messi","Mbappé"};
        ArrayList<Futbolista> listFut = new ArrayList<>();
        
        System.out.println("----------------------");
        System.out.println("--- inici dels xuts --");
        System.out.println("----------------------\n");
        for (String nombres : futbolistas) {
            Futbolista fut = new Futbolista(nombres);
            listFut.add(fut);
            fut.start();
        }
        System.out.println("""
                ----------------------
                --- Fi dels xuts -----
                ----------------------

                ----------------------
                --- Estadístiques ----
                ----------------------
                """);
        for (Futbolista futbolista : listFut) {
            try {
                futbolista.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }   
    }
}