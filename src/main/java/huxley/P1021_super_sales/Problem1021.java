package huxley.P1021_super_sales;

import java.util.Scanner;

public class Problem1021 {
    private static int dp(int i, int rc, int n, int[] prices, int[] weights, int[][] memo) {
        if (i == n || rc ==0){
            return 0;
        }
        if (memo[i][rc] != -1) {
            return memo[i][rc];
        }
        if (weights[i] > rc) {
            return dp(i + 1, rc, n, prices, weights, memo);
        }
        int pick = prices[i] + dp(i + 1, rc - weights[i], n, prices, weights, memo);
        int dont = dp(i + 1, rc, n, prices, weights, memo);
        memo[i][rc] = Math.max(pick, dont);
        return memo[i][rc];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int tests = scan.nextInt();

        for (int t = 0; t < tests; t++) {
            int n = scan.nextInt();
            scan.nextLine();
            int [] prices = new int[n], weights = new int[n];

            for (int i = 0; i < n; i++) {
                String[] line = scan.nextLine().split(" ");
                prices[i] = Integer.parseInt(line[0]);
                weights[i] = Integer.parseInt(line[1]);
            }

            int g = scan.nextInt();
            scan.nextLine();
            int[] capacitys = new int[g];
            int maxCap = -1;
            for (int i = 0; i < g; i++) {
                int c = scan.nextInt();
                capacitys[i] = c;
                if (c > maxCap) {
                    maxCap = c;
                }
            }

            int[][] memo = new int[n + 1][maxCap + 1];
            for (int k = 0; k <= n; k++) {
                for (int j = 0; j <= maxCap; j++) {
                    memo[k][j] = -1;
                }
            }

            int totalEarnings = 0;
            for (int i = 0; i < g; i++) {
                int cap = capacitys[i];
                totalEarnings += dp(0, cap, n, prices, weights, memo);
            }
            System.out.println(totalEarnings);
        }
    }
}
