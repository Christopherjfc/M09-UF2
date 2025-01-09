package christopher.futbol;

public class Futbolista extends Thread{
    final int NUM_JUGADORS = 11;
    final int NUM_TIRADES = 20;
    final float PROBABILITAT = 0.5f;
    int ngols;
    int ntirades;

    public Futbolista(String nombres){
        super(nombres);
        ngols = 0;
        ntirades = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {
            if (Math.random() <= PROBABILITAT) {
                ngols++;
            }
            ntirades++;
        }
        System.out.printf("%-10s -> %d gols%n", getName(), ngols);
    }
}
