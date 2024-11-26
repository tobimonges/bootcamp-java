package java002;

import java.util.Arrays;

public class Ejercicio02 {
    public static void main(String[] args) {
        int [] array = new int[100];
        int [] contador = new int[61];
        int mayor = 0;
        int numMayor = 0;
        for (int i = 0; i < 100; i++) {
            array[i] = (int)((Math.random() * 61) - 30);
            contador[array[i] + 30]++;
        }
        for (int i = 0; i < contador.length; i++) {
            if (contador[i] > mayor) {
                mayor = contador[i];
                numMayor = i - 30;
            }
        }
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("El número que más veces se repite es: " + numMayor);
        System.out.print("Los números que no están presentes son: ");
        for (int i = 0; i < contador.length; i++) {
            if (contador[i] == 0) {
                System.out.print(i - 30 + " ");
            }
        }
    }
}