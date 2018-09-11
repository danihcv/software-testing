package huxley.util;

import java.util.ArrayList;

public class Tree {
    public int item;
    public Tree left, right;

    public Tree(int item) {
        this.item = item;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(this);
    }

    public boolean isBinarySearchTree(Tree root) {
        if (root == null || root.left == null || root.right == null)
            return true;
        if (root.left.item >= root.item || root.right.item < root.item)
            return false;
        return isBinarySearchTree(root.left) && isBinarySearchTree(root.right);
    }

    public static Tree formTree(String treeStr) {
        ArrayList<String> treeList = new ArrayList<>();

        int signal = 1;
        for (int i = 0; i < treeStr.length(); i++) {
            if (treeStr.charAt(i) == ' ') {
                continue;
            }

            if (treeStr.charAt(i) == '-') {
                signal = -1;
            } else if (Character.isDigit(treeStr.charAt(i))) {
                int number = treeStr.charAt(i) - '0';
                while (i + 1 < treeStr.length() && Character.isDigit(treeStr.charAt(i + 1))) {
                    number = number * 10 + treeStr.charAt(i + 1) - '0';
                    ++i;
                }
                treeList.add(String.valueOf(number * signal));
                signal = 1;
            } else {
                treeList.add(String.valueOf(treeStr.charAt(i)));
            }
        }

        return formTree(treeList);
    }

    public static Tree formTree(ArrayList<String> treeList) {
        treeList.remove(0); // (
        Tree newBt;

        String pop = treeList.remove(0); // ) ou number
        if (!pop.equals(")")) {
            newBt = new Tree(Integer.parseInt(pop));

            newBt.left = formTree(treeList);
            newBt.right = formTree(treeList);
        } else {
            return null;
        }
        treeList.remove(0); // )

        return newBt;
    }

    public int contains(int element) {
        return contains(this, element, 0);
    }

    private int contains(Tree bt, int element, int nivelAt) {
        if (bt == null) {
            return -1;
        }
        if (bt.item == element) {
            return nivelAt;
        }

        int resL = contains(bt.left, element, nivelAt + 1);
        int resR = contains(bt.right, element, nivelAt + 1);

        if (resL == -1 && resR != -1) {
            return resR;
        } else if (resL != -1 && resR == -1) {
            return resL;
        } else if (resL != -1) {
            return Math.min(resL, resR);
        }
        return -1;
    }
}
