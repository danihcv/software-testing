package huxley.P200_dentista;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Problem200 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        ArrayList<Integer[]> appointments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = scan.nextInt(), f = scan.nextInt();
            appointments.add(new Integer[]{f, s});
        }
        appointments.sort(Comparator.comparing((Integer[] a) -> a[0]));

        int qnt = 1, lastF = appointments.get(0)[0];
        for (int i = 1; i < n; i++) {
            if (appointments.get(i)[1] >= lastF) {
                qnt++;
                lastF = appointments.get(i)[0];
            }
        }

        System.out.print(qnt);
    }
}
