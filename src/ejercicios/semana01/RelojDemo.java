package ejercicios.semana01;

import java.util.ArrayList;
import java.util.Scanner;

public class RelojDemo {
    static ArrayList<Reloj> relojes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int principal;

    public static void main(String[] args) {
        System.out.println("*** Bienvenido ***");
        System.out.println("******************");
        do {
            menu();
        } while (principal > 0 && principal < 7);

    }
    private static int hora(){
        int hora = (int)(Math.random() * 24);
        return hora;
    }
    private static int minuto(){
        int minuto = (int)(Math.random() * 60);
        return minuto;
    }
    private static int segundo(){
        int segundo = (int)(Math.random() * 60);
        return segundo;
    }
    private static int opciones(){
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1 -> Ejecutar enunciado.\n" +
                    "2 -> Crear un reloj.\n" +
                    "3 -> Editar reloj\n" +
                    "4 -> Listar relojes creados\n" +
                    "5 -> Incrementar\n" +
                    "6 -> Decrementar\n" +
                    "0 -> Salir\n");
            System.out.print("\nElije una opcion: ");
            principal = scanner.nextInt();
            scanner.nextLine();
        } while (principal < 0 && principal > 6);
        return principal;
    }
    private static void ejecutarEnunciado() {
        System.out.print("Ingresar segundos para crear su reloj: ");
        int segundos = scanner.nextInt();
        scanner.nextLine();

        Reloj reloj1 = new Reloj(segundos);
        System.out.println("Reloj creado: " + reloj1);

        System.out.println("\nEjecutando la funcion tick:");
        for (int i = 0; i < 10; i++) {
            reloj1.tick();
            System.out.println(reloj1);
        }

        System.out.println("\nCreando un nuevo reloj...");
        Reloj rejoj2 = new Reloj(hora(), minuto(), segundo());

        System.out.println("Restando: " + reloj1 + " - " + rejoj2 + " = " + reloj1.restaReloj(rejoj2));
    }

    private static boolean validarHora(int valor) {
        if (valor >= 0 && valor < 24) {
            return true;
        }
        return false;
    }
    private static boolean validarMinutoSegundo(int valor) {
        if (valor >= 0 && valor < 60) {
            return true;
        }
        return false;
    }
    private static Reloj modificarReloj(Reloj reloj) {
        do {
            System.out.print("Ingresar horas [hh]: ");
            reloj.setHora(scanner.nextInt());
            scanner.nextLine();
        } while (!validarHora(reloj.getHora()));
        do {
            System.out.print("Ingresar minutos [mm]: ");
            reloj.setMinuto(scanner.nextInt());
            scanner.nextLine();
        } while (!validarMinutoSegundo(reloj.getMinuto()));
        do {
            System.out.print("Ingresar segundos [ss]: ");
            reloj.setSegundo(scanner.nextInt());
            scanner.nextLine();
        } while (!validarMinutoSegundo(reloj.getSegundo()));
        return reloj;
    }
    private static void crearReloj() {
        int opcion;
        do {
            System.out.println("1 -> Reloj automatico.\n" +
                    "2 -> Reloj aleatorio\n" +
                    "3 -> Reloj manual\n");
            System.out.print("Como desea crear?: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
        } while (opcion < 1 && opcion > 3);
        switch (opcion) {
            case 1:
                relojes.add(new Reloj());
                break;
            case 2:
                relojes.add(new Reloj(hora(), minuto(), segundo()));
                break;
            case 3:
                Reloj newReloj = new Reloj();
                relojes.add(modificarReloj(newReloj));
        }
    }
    private static void listarRelojes() {
        int j = 1;
        for (Reloj i: relojes) {
            System.out.println(j + "->" + i);
            j++;
        }
    }
    private static int elegirReloj() {
        int x;
        do {
            listarRelojes();
            System.out.print("Elije un reloj: ");
            x = scanner.nextInt();
            scanner.nextLine();
        } while (x < 1 && x > relojes.size());
        return (x-1);
    }
    private static void menu() {
        int opcionMenu = opciones();

        if (opcionMenu == 0) {
            System.out.println("*** Fin del programa ***");
        }
        if (opcionMenu == 1) {
            ejecutarEnunciado();
        }

        if (opcionMenu == 2) {
            crearReloj();
        }
        if (opcionMenu == 3) {
            modificarReloj(relojes.get(elegirReloj()));
        }
        if (opcionMenu == 4) {
            listarRelojes();
        }
        if (opcionMenu == 5) {
            relojes.get(elegirReloj()).tick();
        }
        if (opcionMenu == 6) {
            relojes.get(elegirReloj()).tickDecrement();
        }


    }
}
