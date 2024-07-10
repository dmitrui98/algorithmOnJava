package lesson3;

import common.data.structure.list.CustomLinkedList;

import static util.ArrayUtil.print;

/**
 * Exercise 1.3.30
 * Reverse list and return first node of result list
 */
public class B9_ReverseList {

    public static void main(String[] args) {
        B9_ReverseList instance = new B9_ReverseList();
        instance.testReverseList();
    }

    private void testReverseList() {
        CustomLinkedList<String> list = getListOrdered();
        print(list);
        list.reverseList();
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
