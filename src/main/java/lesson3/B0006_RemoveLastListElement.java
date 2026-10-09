package lesson3;

import edu.princeton.cs.algs4.StdOut;

/**
 * Упражнение 1.3.19
 * Удаление последнего элемента в списке
 */
public class B0006_RemoveLastListElement {

    public static void main(String[] args) {
        Node<String> first = new Node<>("first");
        Node<String> second = new Node<>("second");
        first.next = second;
        Node<String> third = new Node<>("third");
        second.next = third;
        Node<String> fourth = new Node<>("fourth");
        third.next = fourth;
        Node<String> current = first;
        while (current != null) {
            StdOut.print(current.item + " ");
            current = current.next;
        }
        StdOut.println();

        removeLast(first);
        current = first;
        while (current != null) {
            StdOut.print(current.item + " ");
            current = current.next;
        }
    }

    private static void removeLast(Node<String> node) {
        Node<String> previous = null;
        while (node.next != null) {
            previous = node;
            node = node.next;
        }
        if (previous != null) {
            previous.next = null;
        }
    }


    private static class Node<T> {
        T item;
        Node<T> next;

        public Node(T item) {
            this.item = item;
        }
    }
}
