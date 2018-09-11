package huxley.P546_arvore_busca_binaria;

import huxley.util.Tree;

import java.util.Scanner;

public class Problem546 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Tree tree = Tree.formTree(scan.nextLine());

        System.out.println(tree == null || tree.isBinarySearchTree() ? "VERDADEIRO" : "FALSO");
    }
}
