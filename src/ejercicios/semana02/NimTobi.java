package ejercicios.semana02;

import java.util.Scanner;

public class NimTobi {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean seguir = true;
        int turno = 1;


        System.out.print("Jugador 1, ingrese su nombre: ");
        String jugador1 = scanner.nextLine();

        System.out.print("Jugador 2, ingrese su nombre: ");
        String jugador2 = scanner.nextLine();


        int pila1 = (int) ((Math.random() * 5) + 1);
        int pila2 = (int) ((Math.random() * 5) + 1);
        int pila3 = (int) ((Math.random() * 5) + 1);

        while (seguir) {
            imprimirTablero(pila1, pila2, pila3);

            String jugador = turno == 1 ? jugador1 : jugador2;

            System.out.println(jugador + ", elija una pila: ");
            String pila = scanner.nextLine();

            System.out.print("Cuantos quitara de la pila: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            if (pila.equals("A") || pila.equals("a")) {
                if (pila1 - cantidad < 0) {
                    System.out.println("Imposible luego");
                    continue;
                }
                pila1 = (pila1 - cantidad);
            } else if (pila.equals("B") || pila.equals("b")) {
                if (pila2 - cantidad < 0) {
                    System.out.println("Imposible luego");
                    continue;
                }
                pila2 = (pila2 - cantidad);
            } else if (pila.equals("C") || pila.equals("c")) {
                if (pila3 - cantidad < 0) {
                    System.out.println("Impossible luego");
                    continue;
                }
                pila3 = (pila3 - cantidad);
            } else {
                System.out.println("Elije bien!");
                continue;
            }

            if (pila1 == 0 && pila2 == 0 && pila3 == 0) {
                imprimirTablero(pila1, pila2, pila3);
                jugador = turno == 1 ? jugador2 : jugador1;
                System.out.println(jugador + " , ya no quedan contadores, asi que... Ganaste!");
                seguir = false;
            }

            turno = turno == 1 ? 2 : 1;
        }
    }

    public static void imprimirTablero (int pila1, int pila2, int pila3) {
        System.out.println("A: " + pila1
                + " \tB: " + pila2
                + " \tC: " + pila3);
    }
}

