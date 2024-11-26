package java002;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numero;
        System.out.print("Ingresar un numero: ");
        numero = scanner.nextLine();
        int [] numeros = new int[numero.length()];
        for (int i = 0; i < numero.length(); i++) {
            numeros[i] = Integer.parseInt(String.valueOf(numero.charAt(i)));
        }
        System.out.println("Cadena de texto convertido a numeros: " + Arrays.toString(numeros));
    }
}
