package ejercicios.semana01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class App01 {
    public static void main(String[] args) {
        ArrayList<Integer> myNumbers = new ArrayList<Integer>();
        myNumbers.add(33);
        myNumbers.add(15);
        myNumbers.add(20);
        myNumbers.add(34);
        myNumbers.add(8);
        myNumbers.add(12);

        Comparator myComparator = new SortEvenFirst();
        Collections.sort(myNumbers, myComparator);

        for (int i : myNumbers) {
            System.out.println(i);
        }
    }
}