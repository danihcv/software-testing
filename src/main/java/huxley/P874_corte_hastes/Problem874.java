package huxley.P874_corte_hastes;

import java.util.Scanner;

public class Problem874 {
    private static int dp(int n, int[] values, int[] memo) {
        memo[0] = 0;
        for (int j = 1; j <= n; j++) {
            int best = -10;
            for (int i = 0; i < j; i++) {
                int newV = values[i + 1] + memo[j - i - 1];
                best = Math.max(best, newV);
            }
            memo[j] = best;
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            int n = scan.nextInt();
            if (n == 0) {
                break;
            }

            int[] memo = new int[n + 1], prices = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                memo[i] = 0;
                prices[i] = 0;
            }

            for (int i = 1; i <= n; i++) {
                prices[i] = scan.nextInt();
            }
            System.out.println(dp(n, prices, memo));
        }
    }
}
