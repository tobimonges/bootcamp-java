package java002;
import java.util.Arrays;
public class Ejercicio01 {
    public static void main(String[] args) {
        int [] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = (int)((Math.random() * 11) - 5);
        }
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("El mayor elemento del vector es: " + array[9]);
    }
}
