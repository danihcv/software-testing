package huxley.util;

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
        if(root == null || root.left == null || root.right == null)
            return true;
        if(root.left.item >= root.item || root.right.item < root.item)
            return false;
        return isBinarySearchTree(root.left) && isBinarySearchTree(root.right);
    }
}
