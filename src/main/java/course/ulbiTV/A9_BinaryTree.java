package course.ulbiTV;

import common.data.structure.BinaryTree;

public class A9_BinaryTree {

    public static void main(String[] args) {
        new A9_BinaryTree().go();
    }

    private void go() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5);
        tree.add(2);
        tree.add(6);
        tree.add(2);
        tree.add(1);
        tree.print(tree.root);
    }

}
