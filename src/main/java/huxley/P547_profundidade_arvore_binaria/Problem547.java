package huxley.P547_profundidade_arvore_binaria;

import huxley.util.Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem547 {
    private static ArrayList<String> proccesInput(String str) {
        ArrayList<String> treeList = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                continue;
            }

            if (Character.isDigit(str.charAt(i))) {
                int number = str.charAt(i) - '0';
                while (i + 1 < str.length() && Character.isDigit(str.charAt(i + 1))) {
                    number = number * 10 + str.charAt(i) - '0';
                    ++i;
                }
                treeList.add(String.valueOf(number));
            } else {
                treeList.add(String.valueOf(str.charAt(i)));
            }
        }

        treeList.remove(0); // (
        return treeList;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Tree binTree = Tree.formTree(proccesInput(scan.nextLine()));

        int element = scan.nextInt();

        assert binTree != null;
        int res = binTree.contains(element);
        if (res == -1) {
            System.out.println("NAO ESTA NA ARVORE");
        } else {
            System.out.println("ESTA NA ARVORE");
        }
        System.out.printf("%d" + System.lineSeparator(), res);
    }
}
