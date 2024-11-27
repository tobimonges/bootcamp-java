package java005;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Poker {
    //private static int contador = 0;
    public Poker() {
    }

    public String jugada(ArrayList<Carta> mano) {
        if (escaleraColor(mano)) {
            return jugadasPosibles().get(9);
        } else if (poker(mano)) {
            return jugadasPosibles().get(8);
        } else if (full(mano)) {
            return jugadasPosibles().get(7);
        } else if (color(mano)) {
            return jugadasPosibles().get(6);
        } else if (escalera(mano)) {
            return jugadasPosibles().get(5);
        } else if (trio(mano)) {
            return jugadasPosibles().get(4);
        } else if (parDoble(mano)) {
            return jugadasPosibles().get(3);
        } else if (par(mano)) {
            return jugadasPosibles().get(2);
        } else if (cartaAlta(mano)) {
            return jugadasPosibles().get(1);
        } else {
            return "NO OBTUVISTE NADA";
        }
    }

    // ESCALERA COLOR
    private boolean escaleraColor(ArrayList<Carta> mano) {
        return (color(mano) && escalera(mano));
    }

    // POKER
    private boolean poker(ArrayList<Carta> mano) {
        HashMap<String, Integer> valores = contarValores(mano);
        return valores.containsValue(4);
    }


    // FULL
    private boolean full(ArrayList<Carta> mano) {
        HashMap<String, Integer> valores = contarValores(mano);
        return valores.containsValue(3) && valores.containsValue(2);
    }

    // COLOR
    private boolean color(ArrayList<Carta> mano) {
        String palo = mano.get(0).getPalo();
        for (Carta carta : mano) {
            if (!carta.getPalo().equals(palo)) {
                return false;
            }
        }
        return true;
    }


    // ESCALERA
    private boolean escalera(ArrayList<Carta> mano) {
        ArrayList<Integer> valores = new ArrayList<>();

        for (Carta carta : mano) {
            valores.add(carta.getValorNumerico());
        }
        Collections.sort(valores);
        for (int i = 0; i < valores.size() - 1; i++) {
            if (valores.get(i) + 1 != valores.get(i + 1)) {
                return false;
            }
        }
        return true;
    }


    // TRIO
    private boolean trio(ArrayList<Carta> mano) {
        HashMap<String, Integer> valores = contarValores(mano);
        return valores.containsValue(3);
    }


    // PAR DOBLE
    private boolean parDoble(ArrayList<Carta> mano) {
        HashMap<String, Integer> valores = contarValores(mano);
        int pares = 0;
        for (int valor : valores.values()) {
            if (valor == 2) {
                pares++;
            }
        }
        return pares == 2;
    }


    // PAR
    private boolean par(ArrayList<Carta> mano) {
        HashMap<String, Integer> valores = contarValores(mano);
        return valores.containsValue(2);
    }


    // CARTA ALTA
    private boolean cartaAlta(ArrayList<Carta> mano) {
        HashMap<String, Integer> valores = contarValores(mano);
        return valores.containsKey("K");
    }



    // CONTAR VALORES
    private HashMap<String, Integer> contarValores(ArrayList<Carta> mano) {
        HashMap<String, Integer> valores = new HashMap<>();
        for (Carta carta : mano) {
            String valor = carta.getValor();
            valores.put(valor, valores.getOrDefault(valor, 0) + 1);
            //System.out.println("getOrDefault: " + valores.getOrDefault(valor, 1));
        }
        /*
        for (String i : valores.keySet()) {
            System.out.println("valor: " + i + " palo: " + valores.get(i));
        }
        System.out.println("contador: " + (++contador));
         */
        return valores;
    }

    //JUGADAS POSIBLES

    public HashMap<Integer,String> jugadasPosibles() {
        HashMap<Integer, String> resultados = new HashMap<>();
        resultados.put(9,"ESCALERA COLOR");
        resultados.put(8, "POKER");
        resultados.put(7, "FULL");
        resultados.put(6, "COLOR");
        resultados.put(5, "ESCALERA");
        resultados.put(4, "TRIO");
        resultados.put(3, "PAR DOBLE");
        resultados.put(2, "PAR");
        resultados.put(1, "CARTA ALTA");

        return resultados;
    }

}