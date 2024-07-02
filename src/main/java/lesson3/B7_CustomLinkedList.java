package lesson3;

import common.data.structure.list.CustomLinkedList;
import edu.princeton.cs.algs4.StdOut;

/**
 * Упражнение 1.3.20
 * Напишите метод delete() который принимает k и удаляет из связного списка k-й элемент, если он существует
 */
public class B7_CustomLinkedList {

    public static void main(String[] args) {
        B7_CustomLinkedList instance = new B7_CustomLinkedList();
        instance.go();
    }

    private void go() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.removeLast();
        list.removeFirst();
        list.removeAt(0);
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        list.addLast("d");
        list.addLast("10");
        list.addFirst("1");
        list.addFirst("2");
        print(list);

        StdOut.println("Remove first:");
        list.removeFirst();
        print(list);

        StdOut.println("Remove last:");
        list.removeLast();
        print(list);

        StdOut.println("Remove 4:");
        list.removeAt(4);
        print(list);

        StdOut.println("Remove 2:");
        list.removeAt(2);
        print(list);

        StdOut.println("Remove 0:");
        list.removeAt(0);
        print(list);

        StdOut.println("Remove 10:");
        list.removeAt(10);
        print(list);

        StdOut.println("Remove 2:");
        list.removeAt(2);
        print(list);

        StdOut.println("Remove 1:");
        list.removeAt(1);
        print(list);

        StdOut.println("Remove 0:");
        list.removeAt(0);
        print(list);
    }

    private void print(Iterable<?> list) {
        for (Object o : list) {
            StdOut.print(o + " ");
        }
        StdOut.println();
    }
}
