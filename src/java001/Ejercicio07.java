package java001;

public class Ejercicio07 {
    public static void imprimir() {
        for (int i = 1; i < 101; i++) {
            if (i%2 == 0 || i%3 == 0 || i == 1 || i == 100) {
                if (i == 100) {
                    System.out.println(i);
                } else {
                    System.out.print(i + ", ");
                }
            }
        }
    }

    public static void main(String[] args) {
        imprimir();
    }
}
