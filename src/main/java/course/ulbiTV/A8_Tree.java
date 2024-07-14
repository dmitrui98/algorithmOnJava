package course.ulbiTV;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class A8_Tree {

    public static void main(String[] args) {
        A8_Tree tree = new A8_Tree();
        tree.go();
    }

    private void go() {
        List<Node> tree = getTree();
        System.out.println("Рекурсивная сумма: " + recursive(tree));
        System.out.println("Итерационная сумма: " + iteration(tree));
    }

    private List<Node> getTree() {
        List<Node> tree = new ArrayList<>();
        tree.add(
            new Node(
                5,
                List.of(
                    new Node(10, 11),
                    new Node(7, new Node(5, 1))
                )
            )
        );
        tree.add(
            new Node(
                5,
                List.of(new Node(10), new Node(15))
            )
        );
        return tree;
    }

    public int recursive(List<Node> tree) {
        int sum = 0;
        for (Node node : tree) {
            sum += node.item;
            sum += recursive(node.children);
        }
        return sum;
    }

    public int iteration(List<Node> tree) {
        if (tree == null) {
            return 0;
        }
        int sum = 0;
        Stack<Node> stack = new Stack<>();
        tree.forEach(stack::push);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.item);
            sum += node.item;
            node.children.forEach(stack::push);
        }
        return sum;
    }

    private static class Node {
        public Integer item;
        public List<Node> children = new ArrayList<>();

        public Node(Integer item) {
            this.item = item;
        }

        public Node(Integer item, Integer childItem) {
            this.item = item;
            children.add(new Node(childItem));
        }

        public Node(Integer item, Node child) {
            this.item = item;
            children.add(child);
        }

        public Node(Integer item, List<Node> children) {
            this.item = item;
            this.children = children;
        }
    }
}
