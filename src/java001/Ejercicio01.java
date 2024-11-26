package java001;

import java.util.Scanner;

public class Ejercicio01 {
    private static void principal() {
        Scanner scanner = new Scanner(System.in);
        int operacion;
        int num1, num2;
        do {
            System.out.println("Elige una opcion:");
            System.out.println("1 = suma\n2 = resta\n3 = multiplicacion\n4 = division\n5 = modulo\n0 = salir");
            operacion = scanner.nextInt();
            scanner.nextLine();
        } while (operacion < 0 || operacion > 5);


        System.out.println("Ingresar primer numero: ");
        num1 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingresar segundo numero: ");
        num2 = scanner.nextInt();
        scanner.nextLine();

        switch (operacion) {
            case 1:
                System.out.println("La suma es: " + suma(num1, num2));
                break;
            case 2:
                System.out.println("La resta es: " + resta(num1, num2));
                break;
            case 3:
                System.out.println("La multiplicacion es: " + multiplicacion(num1, num2));
                break;
            case 4:
                System.out.println("La division es: " + division(num1, num2));
                break;
            case 5:
                System.out.println("El modulo es: " + modulo(num1, num2));
                break;
            default:
                System.out.println("Fin del programa");
                break;
        }
    }
    private static int suma(int a, int b) {
        return a + b;
    }
    private static int resta(int a, int b) {
        return a - b;
    }
    private static int multiplicacion(int a, int b) {
        return a * b;
    }
    private static float division(float a, float b) {
        return a / b;
    }
    private static int modulo(int a, int b) {
        return a % b;
    }

    public static void main(String[] args) {
        principal();
    }
}
