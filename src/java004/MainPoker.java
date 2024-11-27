package java004;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainPoker {
    public static void main(String[] args) {
        switch (menu()) {
            case 1:
                unaMano();
                break;
            case 2:
                dosManos();
                break;
            default:
                System.out.println(" *** FIN DEL PROGRAMA ***");
                break;
        }
    }

    private static int menu(){
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {

            System.out.print("" +
                    "1 = Una mano\n" +
                    "2 = Dos manos\n" +
                    "0 = Salir\n" +
                    "Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

        } while (opcion < 0 && opcion > 2);

        return opcion;

    }


    private static void unaMano() {

        ArrayList<Carta> mano = new ArrayList<>();

        mano.add(new Carta("A", "H"));
        mano.add(new Carta("3", "D"));
        mano.add(new Carta("3", "D"));
        mano.add(new Carta("6", "D"));
        mano.add(new Carta("6", "D"));

        Poker poker = new Poker();
        String jugada = poker.jugada(mano);
        System.out.println("Resultado: " + jugada);

    }


    private static void dosManos() {

        ArrayList<Carta> mano1 = new ArrayList<>();
        ArrayList<Carta> mano2 = new ArrayList<>();

        mano1.add(new Carta("3", "D"));
        mano1.add(new Carta("3", "T"));
        mano1.add(new Carta("5", "D"));
        mano1.add(new Carta("6", "D"));
        mano1.add(new Carta("7", "D"));

        mano2.add(new Carta("3", "D"));
        mano2.add(new Carta("4", "D"));
        mano2.add(new Carta("5", "D"));
        mano2.add(new Carta("6", "D"));
        mano2.add(new Carta("7", "D"));


        Poker poker = new Poker();

        String jugada1 = poker.jugada(mano1);
        System.out.println("Jugador 1: " + jugada1);

        String jugada2 = poker.jugada(mano2);
        System.out.println("Jugador 2: " + jugada2);

        System.out.println("\nEl ganador es ---> " + ganador(poker.jugadasPosibles(),jugada1,jugada2));

    }
    private static int obtenerKey(HashMap<Integer, String> map, String value) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return -1;
    }

    private static String ganador(HashMap<Integer,String> compara, String jugada1, String jugada2) {
        if (obtenerKey(compara,jugada1 ) > obtenerKey(compara, jugada2)) {
            return "JUGADOR 1";
        } else if (obtenerKey(compara, jugada1) < obtenerKey(compara, jugada2)) {
            return "JUGADOR 2";
        } else {
            return "Empate...";
        }
    }

}
