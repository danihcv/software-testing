package huxley.P781_matriz_aleatoria;

import java.util.Scanner;

public class Problem781 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int l = scan.nextInt(), c = scan.nextInt(), linha, coluna, i = 1, k;
        int[][] matriz = new int[l + 1][c + 1];

        for (linha = 0; linha <= l; linha++) {
            for (coluna = 0; coluna <= c; coluna++) {
                matriz[linha][coluna] = 0;
            }
        }

        for (k = 0; i <= c * l; k++) {
            for (linha = 1 + k; linha <= l - k && i <= c * l; linha++, i++) {
                matriz[linha][1 + k] = i;
            }
            for (linha = l - k; linha > k && i <= c * l; linha--, i++) {
                matriz[linha][c - k] = i;
            }
            for (coluna = 1 + k + 1; coluna < c - k && i <= c * l; coluna++, i++) {
                matriz[l - k][coluna] = i;
            }
            for (coluna = 1 + k + 1; coluna <= c - k - 1 && i <= c * l; coluna++, i++) {
                matriz[1 + k][coluna] = i;
            }
        }

        for (linha = 1; linha <= l; linha++) {
            for (coluna = 1; coluna <= c; coluna++) {
                System.out.printf("%03d", matriz[linha][coluna]);
                if (coluna != c) {
                    System.out.print(" ");
                } else {
                    System.out.print(System.lineSeparator());
                }
            }
        }
    }
}
