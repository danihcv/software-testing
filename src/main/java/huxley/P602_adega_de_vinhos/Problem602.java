package huxley.P602_adega_de_vinhos;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem602 {
    private static int dp(int y, int i, int f, ArrayList<Integer> prices, ArrayList<ArrayList<Integer>> memo) {
        if (i == f) {
            return prices.get(i) * y;
        }
        if (memo.get(i).get(f) != -1) {
            return memo.get(i).get(f);
        }

        int sellFirst = prices.get(i) * y + dp(y + 1, i + 1, f, prices, memo);

        int sellSecond = prices.get(f) * y + dp(y + 1, i, f - 1, prices, memo);

        memo.get(i).set(f, (sellFirst > sellSecond) ? sellFirst : sellSecond);
        return memo.get(i).get(f);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        ArrayList<Integer> prices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            prices.add(scan.nextInt());
        }

        ArrayList<ArrayList<Integer>> memo = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            memo.add(new ArrayList<>());
            for (int j = 1; j <= n; j++) {
                memo.get(i - 1).add(-1);
            }
        }

        System.out.println(dp(1, 0, n - 1, prices, memo));
    }
}
