import businessLogic.BusinessLogic;
import map.MapGenerator;

import java.util.List;

public class Main {

    // pustit pomocí příkazu dvou příkazů
    // pro build projektu
    // javac Main.java
    // pro příkaz v konzoly
    // java Main {argument}ja

    public static void main(String[] args) {

        if (args.length == 0) {
            printUsage();
            return;
        }

        switch (args[0]) {
            case "new" -> BusinessLogic.newSimulation();
            case "save" -> BusinessLogic.saveSimulation();
            case "load" -> BusinessLogic.loadSimulation();
            case "stop" -> BusinessLogic.stopSimulation();
            case "play" -> BusinessLogic.playSimulation();
            default -> printUsage();
        }

    }

    private static void printUsage() {
        System.out.println();
        System.out.println("  Command Line PID_Simulation application");
        System.out.println("==================================================");
        System.out.println();
        System.out.println("  Command line arguments:");
        System.out.println("      new   Run new one");
        System.out.println("      save  save currency");
        System.out.println("      load  load last safe");
        System.out.println("      stop  stop running simulation");
        System.out.println("      play  run currency simulation");
        System.out.println();
        System.out.println();
    }


}
