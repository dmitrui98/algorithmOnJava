package lesson3;

import common.data.structure.list.CustomLinkedList;
import common.data.structure.util.Node;
import edu.princeton.cs.algs4.StdOut;
import static util.ArrayUtil.print;

/**
 * Упражнение 1.3.20
 * Напишите метод delete() который принимает k и удаляет из связного списка k-й элемент, если он существует
 */
public class B7_CustomLinkedList {

    public static void main(String[] args) {
        B7_CustomLinkedList instance = new B7_CustomLinkedList();
        // instance.testListChanges();
        // instance.testFind();
        // instance.testRemoveAfter();
        // instance.testInsertAfter();
        //instance.testRemoveAll();
        //instance.testMax();
        //instance.testMaxRecursive();
    }

    private void testMaxRecursive() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        StdOut.println("Max for empty list: " + list.maxRecursive(list.getFirst(), Integer.MIN_VALUE));
        list = getListInt();
        print(list);
        StdOut.println("Max: " + list.maxRecursive(list.getFirst(), Integer.MIN_VALUE));
    }

    private void testMax() {
        StdOut.println("Max not integer items: " + getList().max());
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        StdOut.println("Max for empty list: " + list.max());
        list = getListInt();
        print(list);
        StdOut.println("Max: " + list.max());
    }

    private void testRemoveAll() {
        CustomLinkedList<String> list = getList();
        print(list);
        list.addFirst("r");
        list.addFirst("e");
        list.addFirst("r");
        list.addFirst("r");
        list.addFirst("r");
        list.addLast("r");
        list.addLast("r");
        list.addLast("e");
        list.addLast("e");
        list.addLast("e");
        list.addLast("r");
        list.addLast("r");
        print(list);
        int countRemoved = list.removeAll("r");
        print(list);
        StdOut.println("Count removed: " + countRemoved);
    }

    private void testInsertAfter() {
        CustomLinkedList<String> list = getList();
        list.addLast("one");
        Node<String> target = list.addLast("two");
        list.addLast("three");
        list.addLast("four");
        print(list);
        list.insertAfter(target, new Node<>("itemForInsert"));
        print(list);
    }

    private void testRemoveAfter() {
        CustomLinkedList<String> list = getList();
        list.addLast("one");
        list.addLast("two");
        Node<String> target = list.addLast("target");
        list.addLast("three");
        list.addLast("four");
        print(list);
        list.removeAfter(target);
        print(list);
        list.removeAfter(target);
        list.removeAfter(target);
        list.removeAfter(target);
        print(list);
    }

    private void testFind() {
        CustomLinkedList<String> list = getList();
        print(list);
        StdOut.println(list.find("a"));
        StdOut.println(list.find("2"));
        StdOut.println(list.find("10"));
    }

    private void testListChanges() {
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

    private CustomLinkedList<String> getList() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        list.addLast("d");
        list.addLast("10");
        list.addFirst("1");
        list.addFirst("2");
        return list;
    }

    private CustomLinkedList<Integer> getListInt() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.addLast(88);
        list.addLast(8);
        list.addLast(1);
        list.addLast(0);
        list.addLast(33);
        list.addFirst(198);
        list.addFirst(15);
        list.addFirst(99);
        return list;
    }
}
