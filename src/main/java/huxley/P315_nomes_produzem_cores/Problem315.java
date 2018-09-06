package huxley.P315_nomes_produzem_cores;

import java.util.Scanner;

public class Problem315 {
    public static int hexToDecimal(String hex) {
        int value = 0;
        for (int i = 0; i < hex.length(); i++) {
            int aux;
            if (Character.isAlphabetic(hex.charAt(i))) {
                aux = (10 + hex.charAt(i) - 'a');
            } else {
                aux = hex.charAt(i) - '0';
            }
            value += aux * Math.pow(16, (hex.length() - 1 - i));
        }
        return value;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        input = input.toLowerCase();

        StringBuilder str = new StringBuilder();
        int remaining = (3 - (input.length() % 3)) % 3;
        for (int i = 0; i < input.length() + remaining; i++) {
            if (i < input.length()) {
                char c = input.charAt(i);
                if (c > 'f') {
                    c = '0';
                }
                str.append(c);
            } else {
                str.append('0');
            }
        }

        System.out.print("(");
        int chunkSize = str.length() / 3;
        for (int i = 0; i < 3; i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(hexToDecimal(str.substring(i * chunkSize, i * chunkSize + (chunkSize > 2 ? 2 : chunkSize))));
        }
        System.out.print(")");
    }
}
