package java001;

import java.util.Scanner;

public class Ejercicio04 extends Ejercicio03 {
    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }
    public String getNombre() {
        return nombre;
    }

    public static void ingresarNombre(Ejercicio04 ejercicio4) {
        //java001.Ejercicio4 ejercicio4 = new java001.Ejercicio4();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresar su nombre: ");
        ejercicio4.setNombre(scanner.nextLine());

    }

    public static void main(String[] args) {
        Ejercicio04 ejercicio4 = new Ejercicio04();
        ingresarNombre(ejercicio4);
        System.out.println("Bienvenido " + ejercicio4.getNombre());

    }
}
