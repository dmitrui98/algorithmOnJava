package common.data.structure.util;

public class BinaryTree<T extends Comparable<T>> {
    public TreeNode<T> root;

    public TreeNode<T> add(T item) {
        TreeNode<T> addNode = new TreeNode<>(item);
        if (root == null) {
            root = addNode;
        } else {
            TreeNode<T> node = root;
            while (node != null) {
                TreeNode<T> tmp = node;
                if (item.compareTo(node.item) < 0) {
                    node = node.left;
                    if (node == null) {
                        tmp.left = addNode;
                    }
                } else {
                    node = node.right;
                    if (node == null) {
                        tmp.right = addNode;
                    }
                }
            }
        }
        return addNode;
    }

    public void print(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.item);
        print(node.left);
        print(node.right);
    }
}
