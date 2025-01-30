package com.christopher.espera;

import java.util.List;

public class Esdeveniment {
    private int placesDisponibles = 10;
    private List<Assistent> assistents;
    
    public Esdeveniment(int places){
        setPlacesDisponibles(places);
    }
    
    public synchronized boolean ferReserva(Assistent as) {
        if (placesDisponibles > 0 && !assistents.contains(as)) {
            assistents.add(as);
            placesDisponibles -= 1;
            return true;
        }
        return false;
    }

    public synchronized boolean cancelaReserva(Assistent as){
        if (assistents.contains(as)) {
            assistents.remove(as);
            placesDisponibles += 1;
            return true;
        }
        return false;
    }

    public int getPlacesDisponibles() {
        return placesDisponibles;
    }

    public void setPlacesDisponibles(int placesDisponibles) {
        if (placesDisponibles > 0) {
            this.placesDisponibles = placesDisponibles;
        }
    }

    public List<Assistent> getAssistents() {
        return assistents;
    }
}
