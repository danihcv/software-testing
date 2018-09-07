package huxley.P179_batalha_naval;

import java.util.Scanner;

public class Problem179 {
    private static int confereNavio(int x, int y, int l, int c, char mapa[][]) {
        int temp = 0, temp2;
        if (mapa[x][y - 1] == '#' || mapa[x - 1][y] == '#' || mapa[x][y + 1] == '#' || mapa[x + 1][y] == '#')
            return -1;
        mapa[x][y] = 'V';
        if (mapa[x][y - 1] == '@')
            temp = confereNavio(x, y - 1, l, c, mapa);
        if (mapa[x - 1][y] == '@') {
            temp2 = confereNavio(x - 1, y, l, c, mapa);
            if (temp2 == -1)
                temp = -1;
        }
        if (mapa[x][y + 1] == '@') {
            temp2 = confereNavio(x, y + 1, l, c, mapa);
            if (temp2 == -1)
                temp = -1;
        }
        if (mapa[x + 1][y] == '@') {
            temp2 = confereNavio(x + 1, y, l, c, mapa);
            if (temp2 == -1)
                temp = -1;
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int destruidos = 0;
        int l = scan.nextInt(), c = scan.nextInt();
        char[][] mapa = new char[l + 2][c + 2];
        int linha, coluna, i, ataques, x, y;
        for (coluna = 0; coluna <= c + 1; coluna++) {
            mapa[0][coluna] = '.';
            mapa[l + 1][coluna] = '.';
        }
        scan.nextLine();
        for (linha = 1; linha <= l; linha++) {
            String line = scan.nextLine();
            for (coluna = 1; coluna <= c; coluna++) {
                mapa[linha][coluna] = line.charAt(coluna - 1);
            }
            mapa[linha][0] = '.';
            mapa[linha][c + 1] = '.';
        }
        ataques = scan.nextInt();
        for (i = 0; i < ataques; i++) {
            x = scan.nextInt();
            y = scan.nextInt();
            if (mapa[x][y] == '#') {
                mapa[x][y] = '@';
            }
        }
        for (linha = 1; linha <= l; linha++) {
            for (coluna = 1; coluna <= c; coluna++) {
                if (mapa[linha][coluna] == '@') {
                    if (confereNavio(linha, coluna, l, c, mapa) == 0) {
                        destruidos++;
                    }
                }
            }
        }
        System.out.println(destruidos);
    }
}
