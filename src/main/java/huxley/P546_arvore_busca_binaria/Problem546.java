package huxley.P546_arvore_busca_binaria;

import huxley.util.Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem546 {
    private static Scanner scan;

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

    private static Tree formTree(ArrayList<String> treeList){
        Tree newBt;

        String pop = treeList.remove(0);
        if(!pop.equals(")")){
            newBt = new Tree(Integer.parseInt(pop));

            treeList.remove(0); // (
            newBt.left = formTree(treeList);
            treeList.remove(0); // (
            newBt.right = formTree(treeList);
        } else {
            return null;
        }
        treeList.remove(0); // )

        return newBt;
    }

    public static void main(String[] args) {
        scan = new Scanner(System.in);

        Tree tree = formTree(proccesInput(scan.nextLine().replaceAll(" ", "")));

        System.out.println(tree == null || tree.isBinarySearchTree() ? "VERDADEIRO" : "FALSO");
    }
}
