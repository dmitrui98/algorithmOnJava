package lesson3;

import common.data.structure.list.CustomDoubleLinkedList;
import common.data.structure.util.DoubleNode;
import edu.princeton.cs.algs4.StdOut;
import static util.ArrayUtil.print;

/**
 * Exercise 1.3.31
 * Implement DoubleList Node(prev, next)
 * AddFirst, addLast, removeFirst, removeLast, insertBefore, insertAfter, removeAt
 */
public class B10_DoubleList {

    public static void main(String[] args) {
        B10_DoubleList test = new B10_DoubleList();
        test.go();
    }

    private void go() {
        CustomDoubleLinkedList<String> list = new CustomDoubleLinkedList<>();
        list.addFirst("10");
        list.addFirst("9");
        list.addFirst("8");
        list.addFirst("7");
        list.addFirst("6");
        print(list); // 6 7 8 9 10
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        StdOut.println("After a lot remove:");
        print(list);

        CustomDoubleLinkedList<String> list1 = new CustomDoubleLinkedList<>();
        DoubleNode<String> node1 = list1.addLast("6");
        list1.addLast("7");
        list1.addLast("8");
        list1.addLast("9");
        list1.addLast("10");
        list1.addFirst("1");
        list1.addFirst("2");
        list1.addLast("21");
        list1.addLast("22");
        list1.addFirst("111");
        list1.addFirst("112");
        list1.addFirst("113");
        list1.addLast("5");
        print(list1); // 113 112 111 2 1 6 7 8 9 10 21 22 5
        list1.removeLast();
        list1.removeLast();
        list1.removeFirst();
        DoubleNode<String> node = list1.removeFirst();
        print(list1); // 111 2 1 6 7 8 9 10 21
        list1.remove(node1);
        StdOut.println("After remove:");
        print(list1);

        CustomDoubleLinkedList<String> list2 = new CustomDoubleLinkedList<>();
        list2.remove(node);
        StdOut.println("Remove 1:");
        print(list2);

        node = list2.addLast("10");
        list2.remove(node);
        StdOut.println("Remove 2:");
        print(list2);

        list2.addLast("20");
        final DoubleNode<String> node30 = list2.addLast("30");
        node = list2.addLast("40");
        list2.remove(node);
        StdOut.println("Remove 3:");
        print(list2);

        final DoubleNode<String> node50 = list2.addLast("50");
        node = list2.addLast("60");
        list2.addLast("70");
        list2.remove(node);
        print(list2); // 20 30 50 70
        StdOut.println(list2.insertAfter(node30, "31"));
        print(list2);
        StdOut.println(list2.insertBefore(node50, "49"));
        print(list2);

        list2.insertAfter(list2.getFirst(), "a");
        list2.insertBefore(list2.getFirst(), "b");
        list2.insertBefore(list2.getLast(), "a");
        list2.insertAfter(list2.getLast(), "b");
        print(list2);
    }
}
