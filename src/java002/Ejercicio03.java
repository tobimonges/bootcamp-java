package java002;

import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palabra;
        System.out.print("Ingresar una palabra o texto: ");
        palabra = scanner.nextLine();
        if (esPalindromo(palabra)) {
            System.out.println("La palabra es un palindromo");
        } else {
            System.out.println("La palabra no es un palindromo");
        }
    }
    static boolean esPalindromo(String palabra) {
        String palabraSinEspacios = palabra.replace(" ", "");
        String palabraInvertida = "";
        for (int i = palabraSinEspacios.length() - 1; i >= 0; i--) {
            palabraInvertida += palabraSinEspacios.charAt(i);
        }
        return palabraInvertida.equals(palabraSinEspacios);
    }
}
