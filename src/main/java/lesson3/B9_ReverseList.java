package lesson3;

import common.data.structure.list.CustomLinkedList;
import common.data.structure.util.Node;
import edu.princeton.cs.algs4.StdOut;
import static util.ArrayUtil.print;

/**
 * Exercise 1.3.30
 * Reverse list and return first node of result list
 */
public class B9_ReverseList {

    public static void main(String[] args) {
        B9_ReverseList instance = new B9_ReverseList();
        instance.testReverseList();
        instance.testReverseListRecursive();
    }

    private void testReverseList() {
        CustomLinkedList<String> list = getListOrdered();
        print(list);
        Node<String> firstReversed = list.reverseList();
        StdOut.println("First reversed: " + firstReversed);
        print(list);

        list = new CustomLinkedList<>();
        list.addLast("10");
        list.reverseList();
        print(list);
        list.addLast("20");
        list.reverseList();
        print(list);
    }

    private void testReverseListRecursive() {
        StdOut.println("###Recursive###");
        CustomLinkedList<String> list = getListOrdered();
        print(list);
        Node<String> firstReversed = list.reverseListRecursive(list.getFirst());
        StdOut.println("First reversed: " + firstReversed);
        print(list);

        list = new CustomLinkedList<>();
        list.addLast("10");
        list.reverseListRecursive(list.getFirst());
        print(list);
        list.addLast("20");
        list.reverseListRecursive(list.getFirst());
        print(list);
    }

    private CustomLinkedList<String> getListOrdered() {
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.addLast("5");
        list.addLast("6");
        list.addLast("7");
        return list;
    }
}
