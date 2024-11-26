package java001;

import java.util.Scanner;

public class Ejercicio06 {
    private final int IVA = 11;
    private float precio;

    public int getIVA() {
        return IVA;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public static float iva(Ejercicio06 producto){
        return (producto.getPrecio()/producto.getIVA());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ejercicio06 producto = new Ejercicio06();

        System.out.print("Ingresar el precio del producto: ");
        producto.setPrecio(scanner.nextFloat());

        System.out.printf("El IVA es: %.2f", iva(producto));
    }
}
