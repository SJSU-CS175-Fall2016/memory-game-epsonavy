package cs175.memorygame;

import android.app.Application;
import java.util.HashMap;

public class MyApp extends Application {
    private boolean renewBoolean = false;
    private HashMap<Integer, Integer> randomHM = new HashMap<>(20);
    private HashMap<Integer, Boolean> vanishHM= new HashMap<>(20);
    private int score;

    public void storeBoolean(boolean data) {
        this.renewBoolean = data;
    }

    public void storeHM(HashMap<Integer, Integer> hm) {
        this.randomHM = hm;
    }

    public void storeVanishHM(HashMap<Integer, Boolean> hm) {
        this.vanishHM = hm;
    }

    public void storeScore(int s) {
        this.score = s;
    }

    public boolean getBoolean() {
        return renewBoolean;
    }

    public HashMap<Integer, Integer> getHM() {
        return randomHM;
    }

    public HashMap<Integer, Boolean> getVanishHM() {
        return vanishHM;
    }

    public int getScore() {
        return score;
    }

}

