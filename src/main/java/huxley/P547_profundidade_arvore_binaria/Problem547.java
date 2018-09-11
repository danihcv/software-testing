package huxley.P547_profundidade_arvore_binaria;

import huxley.util.Tree;

import java.util.Scanner;

public class Problem547 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Tree binTree = Tree.formTree(scan.nextLine());

        int element = scan.nextInt();

        assert binTree != null;
        int res = binTree.contains(element);
        if (res == -1) {
            System.out.println("NAO ESTA NA ARVORE");
        } else {
            System.out.println("ESTA NA ARVORE");
        }
        System.out.print(res);
    }
}
