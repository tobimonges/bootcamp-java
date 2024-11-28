package java004;

import java.util.ArrayList;

public class MainPoker {
    public static void main(String[] args) {

        ArrayList<Carta> mano = new ArrayList<>();

        mano.add(new Carta("A", "H"));
        mano.add(new Carta("3", "D"));
        mano.add(new Carta("3", "D"));
        mano.add(new Carta("6", "D"));
        mano.add(new Carta("6", "D"));

        Poker poker = new Poker();
        String jugada = poker.jugada(mano);
        System.out.println("Resultado: " + jugada);
    }
}
