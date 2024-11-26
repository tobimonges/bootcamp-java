package java003;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Generala {

    int tirarDados() {
        return (int) ((Math.random() * 6) + 1);
    }

    String jugada(ArrayList<Integer> dados) {
        String jugada = "";
        if (esGenerala(dados)) {
            jugada = "Generala";
        } else if (esPoker(dados)) {
            jugada = "Poker";
        } else if (esFull(dados)) {
            jugada = "Full";
        } else if (esEscalera(dados)) {
            jugada = "Escalera";
        } else {
            jugada = "Nada";
        }
        return jugada;

    }

    private boolean esEscalera(ArrayList<Integer> dados) {
        for (int i = 0; i < dados.size() - 1; i++) {
            if (dados.get(i) + 1 != dados.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean esFull(ArrayList<Integer> dados) {
        int contador = 0;
        for (int i = 0; i < dados.size(); i++) {
            for (int j = 0; j < dados.size(); j++) {
                if (dados.get(i) == dados.get(j)) {
                    contador++;
                }
            }
            if (contador == 3) {
                for (int j = 0; j < dados.size(); j++) {
                    for (int k = 0; k < dados.size(); k++) {
                        if (dados.get(j) == dados.get(k) && dados.get(j) != dados.get(i)) {
                            return true;
                        }
                    }
                }
            }
            contador = 0;
        }
        return false;
    }

    private boolean esPoker(ArrayList<Integer> dados) {
        int contador = 0;
        for (int i = 0; i < dados.size(); i++) {
            for (int j = 0; j < dados.size(); j++) {
                if (dados.get(i) == dados.get(j)) {
                    contador++;
                }
            }
            if (contador == 4) {
                return true;
            }
            contador = 0;
        }
        return false;
    }

    private boolean esGenerala(ArrayList<Integer> dados) {
        for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i) != dados.get(0)) {
                return false;
            }
        }
        return true;
    }


    static void menu(Generala generala) {
        Scanner scanner = new Scanner(System.in);
        boolean seguir = true;
        while (seguir) {
            System.out.println("1. Tirar dados");
            System.out.println("2. Salir");
            System.out.print("Opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    ArrayList<Integer> dados = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        dados.add(generala.tirarDados());
                    }
                    Collections.sort(dados);

                    System.out.println("Dados: " + dados);
                    System.out.println("Obtuviste: " + generala.jugada(dados));
                    break;
                case 2:
                    seguir = false;
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Generala generala = new Generala();

        menu(generala);
    }
}
