package lesson3;

import edu.princeton.cs.algs4.StdOut;

public class A5_List {

    public static void main(String[] args) {
        new A5_List().go();
    }

    private void go() {
        Node<String> first = new Node<>();
        first.item = "to";

        Node<String> second = new Node<>();
        second.item = "be";
        first.next = second;

        Node<String> third = new Node<>();
        third.item = "or";
        second.next = third;

        StdOut.println(first);
        StdOut.println("Вставка: ");
        Node<String> newFirst = addFirst(first, "not");
        StdOut.println(newFirst);

        StdOut.println("Удаление: ");
        newFirst = removeFirst(newFirst);
        StdOut.println(newFirst);
        newFirst = removeFirst(newFirst);
        StdOut.println(newFirst);

        int i = 1;
        for (Node<?> x = first; x != null; x = x.next, i++) {
            StdOut.printf("Обработка элемента (%s): %s \n", i, x.item);
        }
    }

    private <T> Node<T> addFirst(Node<T> first, T item) {
        Node<T> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        return first;
    }

    private <T> Node<T> removeFirst(Node<T> first) {
        return first.next;
    }

    private static class Node<T> {
        T item;
        Node<T> next;

        @Override
        public String toString() {
            return item + (next == null ? "" : " " + next);
        }
    }
}
