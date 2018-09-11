package huxley.P241_marmore;

import java.util.Scanner;

public class Problem241 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int i, j, n, q, teste = 0, busca;
        boolean found;
        n = scan.nextInt();
        q = scan.nextInt();
        while (n != 0) {
            int[] num = new int[n + 1];
            for (i = 1; i <= n; i++) {
                num[i] = scan.nextInt();
            }
            for (j = n; j > 1; j--) {
                for (i = 1; i < j; i++) {
                    if (num[i] > num[i + 1]) {
                        num[0] = num[i];
                        num[i] = num[i + 1];
                        num[i + 1] = num[0];
                    }
                }
            }
            teste++;
            System.out.printf("CASE# %d:" + System.lineSeparator(), teste);
            for (; q > 0; q--) {
                found = false;
                busca = scan.nextInt();
                for (i = 1; i <= n; i++) {
                    if (num[i] == busca) {
                        System.out.printf("%d found at %d" + System.lineSeparator(), busca, i);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.printf("%d not found" + System.lineSeparator(), busca);
                }
            }

            n = scan.nextInt();
            q = scan.nextInt();
        }
    }
}
