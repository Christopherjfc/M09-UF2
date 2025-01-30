package com.christopher.espera;

public class Organitzador {
    private int numAssistents;
    private Assistent[] assistents;
    
    public Organitzador() {
        numAssistents = 10;
        assistents = new Assistent[numAssistents];
        Esdeveniment esdeveniment = new Esdeveniment(5);
        for (int i = 0; i < assistents.length; i++) {
            assistents[i] = new Assistent("Assistent-"+i, esdeveniment);
        }
    }

    public void iniciaFils() {
        for (Assistent assistent : assistents) {
            assistent.start();
        }
    }

    public static void main(String[] args) {
        Organitzador organitzador = new Organitzador();
        organitzador.iniciaFils();
    }
}