package java001;

import java.util.Scanner;

public class Ejercicio10 {
    private String [] dias = {"DOMINGO", "SABADO"};

    public String[] getDias() {
        return dias;
    }

    public Ejercicio10() {}

    static boolean comparar(String dia, Ejercicio10 dias) {
        for (String diaLaboral : dias.getDias()) {
            if (dia.equalsIgnoreCase(diaLaboral)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Ejercicio10 ejercicio10 = new Ejercicio10();
        Scanner scanner = new Scanner(System.in);
        String dia;
        System.out.print("Introducir un dia de la semana: ");
        dia = scanner.nextLine();
        System.out.println(comparar(dia, ejercicio10) ? "Es un dia laboral" : "NO es un dia laboral");

    }
}
