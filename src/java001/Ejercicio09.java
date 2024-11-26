package java001;

import java.util.Scanner;

public class Ejercicio09 {
    private String password = "nomeacuerdo";

    public String getPassword() {
        return password;
    }

    public Ejercicio09() {}

    static void ingresarPassword(Ejercicio09 pass) {
        Scanner scanner = new Scanner(System.in);
        String pass2;
        int i = 3;

        while (i > 0) {
            System.out.print("Ingresar la contrasena: ");
            pass2 = scanner.nextLine();
            if (pass2.equals(pass.getPassword())) {
                System.out.println("Correcto!");
                break;
            }
            --i;
            System.out.println("Le quedan " + (i) + " intentos!");
        }
        if (i == 0) {
            System.out.println("Fallaste jaja!!");
        }
    }

    public static void main(String[] args) {
        Ejercicio09 ejercicio09 = new Ejercicio09();
        ingresarPassword(ejercicio09);
    }
}
