package huxley.P674_estudo_de_sequencias;

import java.util.Scanner;

public class Problem674 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt(), inicio = 0, fim = 0, a = 0, b = 0, razao = -10000;
            int[] seq = new int[n];
            for (int i = 0; i < n; i++) {
                seq[i] = scan.nextInt();
            }

            for (int i = 0; i < n - 1; i++) {
                if (razao == -10000) {
                    razao = seq[i + 1] - seq[i];
                    inicio = i;
                    fim = i + 1;
                } else if (seq[i + 1] - seq[i] != razao) {
                    a = i;
                    b = i + 1;
                    razao = seq[i + 1] - seq[i];
                } else {
                    b = i + 1;
                    if (b - a > fim - inicio) {
                        inicio = a;
                        fim = b;
                    }
                }
            }
            System.out.printf("%d %d%s", inicio + 1, fim + 1, System.lineSeparator());
        }
    }
}
