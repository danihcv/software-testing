package huxley.P319_foco_fotografias;

import java.util.Scanner;

public class Problem319 {
    static class Interval {
        int begin;
        int end;

        Interval(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int qntd = 1;

        Interval[] objetos = new Interval[n];
        Interval temp;

        for (int i = 0; i < n; i++) {
            objetos[i] = new Interval(scan.nextInt(), scan.nextInt());
        }

        for (int j = 0; j < n; j++) {
            for (int i = j + 1; i < n; i++) {
                if (objetos[j].end > objetos[i].end) {
                    temp = objetos[i];
                    objetos[i] = objetos[j];
                    objetos[j] = temp;
                }
            }
        }

        int maiorHist = objetos[0].end;
        for (int i = 1; i < n; i++) {
            if (objetos[i].begin > maiorHist) {
                qntd++;
                maiorHist = objetos[i].end;
            }
        }
        System.out.printf("%d%s", qntd, System.lineSeparator());
    }
}
