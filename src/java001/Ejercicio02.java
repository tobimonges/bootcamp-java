package java001;

import java.util.Scanner;

public class Ejercicio02 {
    public static void principal() {
        Scanner scanner = new Scanner(System.in);
        int num1, num2;

        System.out.print("Ingresar primer numero: ");
        num1 = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingresar segundo numero: ");
        num2 = scanner.nextInt();
        scanner.nextLine();

        comparar(num1, num2);

    }
    public static void comparar(int a, int b) {
        if (a == b) {
            System.out.println(a + " y " + b + " son iguales.");
        } else if (a > b) {
            System.out.println(a + " es mayor que " + b);
        } else {
            System.out.println(a + " es menor que " + b);
        }
    }

    public static void main(String[] args) {
        principal();
    }
}
