package java001;

import java.util.Scanner;

public class Ejercicio08 {
    private int numero;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public Ejercicio08(){}


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ejercicio08 ejercicio8 = new Ejercicio08();
        do {
            System.out.print("Ingresa un numero mayor o igual a 0: ");
            ejercicio8.setNumero(scanner.nextInt());
        } while (ejercicio8.getNumero() < 0);
        System.out.println("El valor es: " + ejercicio8.getNumero());
    }
}
