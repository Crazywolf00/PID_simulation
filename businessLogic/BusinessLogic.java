package businessLogic;

import map.MapGenerator;
import map.MapVisualizer;

public class BusinessLogic {

    public static void newSimulation() {
        MapGenerator.load();
        playSimulation();
    }


    public static void playSimulation() {
        //todo časovač opakování
        //todo pohyb vlaků a cestujících
        MapVisualizer.load();
    }

    public static void stopSimulation() {
        //todo zastavit časovač
    }
    public static void startSimulation() {
        //todo odzastavit časovač
    }
    public static void saveSimulation() {
        //todo zastavit časovač
        //todo uložit pozici
    }
    public static void loadSimulation() {
        //todo zastavit časovač
        //todo uložit pozici
        //todo odzastavit časovač
    }


}
