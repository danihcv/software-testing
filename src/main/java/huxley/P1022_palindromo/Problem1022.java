package huxley.P1022_palindromo;

import java.util.Scanner;

public class Problem1022 {
    private static int dp(char[] word, int i, int f, int[][] memo) {
            if (i == f) {
                return 1;
            }
            if (i > f) {
                return 0;
            }
            if (memo[i][f] != -1) {
                return memo[i][f];
            }
            if (word[i] != word[f]) {
                int removeFirst = dp(word, i + 1, f, memo);
                int removeSecond = dp(word, i, f - 1, memo);
                memo[i][f] = Math.max(removeFirst, removeSecond);
                return memo[i][f];
            }
        memo[i][f] = 2 + dp(word, i+1, f-1, memo);
        return memo[i][f];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < t; i++) {
            char[] word = scan.nextLine().toCharArray();
            int[][] memo = new int[word.length + 1][word.length + 1];
            for (int k = 0; k <= word.length; k++) {
                for (int j = 0; j <= word.length; j++) {
                    memo[k][j] = -1;
                }
            }
            System.out.println(dp(word, 0, word.length - 1, memo));
        }
    }
}
