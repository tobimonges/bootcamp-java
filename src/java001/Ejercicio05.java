package java001;

import java.util.Scanner;

public class Ejercicio05 {
    public static void calcular(int a) {
        if (a % 2 == 0) {
            System.out.println(a + " es divible entre 2");
        } else {
            System.out.println(a + " NO es divisible entre 2");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1;

        System.out.print("Ingresar un numero: ");
        num1 = scanner.nextInt();
        scanner.nextLine();

        calcular(num1);
    }
}
