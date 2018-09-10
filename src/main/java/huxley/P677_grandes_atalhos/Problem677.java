package huxley.P677_grandes_atalhos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem677 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();

        for (; t > 0; t--) {
            String str;
            str = scan.nextLine();
            int n = scan.nextInt();
            scan.nextLine();
            Map<Character, String> dicionario = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String[] line = scan.nextLine().split(" ");
                char indiceChar = line[0].charAt(0);
                dicionario.put(indiceChar, line[1]);
            }

            for (int i = 0; i < str.length(); i++) {
                String curr = i + 1 < str.length() ? dicionario.get(str.charAt(i + 1)) : null;
                if (str.charAt(i) == '*' && curr != null && curr.length() != 0) {
                    System.out.printf("%s", dicionario.get(str.charAt(i + 1)));
                    ++i;
                } else {
                    System.out.printf("%c", str.charAt(i));
                }
            }
            System.out.print(System.lineSeparator());
        }
    }
}
