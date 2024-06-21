import java.util.List;

public class Main {

    // pustit pomocí příkazu dvou příkazů
    // pro build projektu
    // javac Main.java
    // pro příkaz v konzoly
    // java Main {argument}


    public static void main(String[] args) {
        if (args.length == 0) {
            printUsage();
            return;
        }


        switch (args[0]) {
            case "new":
                System.out.println("todo new");
                break;
            case "safe":
                System.out.println("todo safe");
                break;
            case "load":
                System.out.println("todo load");
                break;
            case "stop":
                System.out.println("todo stop");
                break;
            case "play":
                System.out.println("todo play");
                break;
            default:
                printUsage();
        }

    }

    private static void printUsage() {
        System.out.println();
        System.out.println("  Command Line PID_Simulation application");
        System.out.println("==================================================");
        System.out.println();
        System.out.println("  Command line arguments:");
        System.out.println("      new   Run new one");
        System.out.println("      safe  safe currency");
        System.out.println("      load  load last safe");
        System.out.println("      stop  stop running simulation");
        System.out.println("      play  run currency simulation");
        System.out.println();
        System.out.println();
    }


}
