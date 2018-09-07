package huxley.P671_bom_amigo_secreto;

import java.util.Scanner;

public class Problem671 {
    private static long fatorial(long n) {
        if (n <= 2)
            return 1;
        return (n * fatorial(n - 1)) % 1000000007;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int casos = scan.nextInt();
        for (; casos > 0; casos--) {
            long n = scan.nextLong();
            if (n > 2)
                --n;
            System.out.print(fatorial(n) + System.lineSeparator());
        }
    }
}
