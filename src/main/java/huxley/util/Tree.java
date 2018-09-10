package huxley.util;

import java.util.ArrayList;

public class Tree {
    private int item;
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

    public static Tree formTree(ArrayList<String> treeList) {
        Tree newBt;

        String pop = treeList.remove(0); // (
        if (!pop.equals(")")) {
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

    public int contains(int element) {
        return contains(this, element, 0);
    }

    private int contains(Tree bt, int element, int nivelAt) {
        if (bt == null)
            return -1;
        if (bt.item == element) {
            return nivelAt;
        }

        int resL = contains(bt.left, element, nivelAt + 1);
        int resR = contains(bt.right, element, nivelAt + 1);

        if (resL == -1 && resR != -1)
            return resR;
        else if (resL != -1 && resR == -1)
            return resL;
        else if (resL != -1)
            return Math.min(resL, resR);
        return -1;
    }
}
