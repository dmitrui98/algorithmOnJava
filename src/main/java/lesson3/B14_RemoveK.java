package lesson3;

import common.data.structure.deque.ResizingArrayDeque;
import common.data.structure.list.CustomDoubleLinkedList;
import common.data.structure.list.CustomLinkedList;
import common.data.structure.util.base.Deque;
import edu.princeton.cs.algs4.StdOut;
import util.ArrayUtil;

/**
 * Упражнение 1.3.38
 * Удаление k-го элемента.
 * Реализация на основе массива и на основе связного списка
 */
public class B14_RemoveK {
    public static void main(String[] args) {
        StdOut.println("Custom linked list:");
        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        ArrayUtil.print(list);
        list.removeAt(1);
        ArrayUtil.print(list);
        list.removeAt(1);
        ArrayUtil.print(list);

        StdOut.println("Custom double linked list:");
        Deque<String> listDeque = new CustomDoubleLinkedList<>();
        listDeque.pushRight("1");
        listDeque.pushRight("2");
        listDeque.pushRight("3");
        ArrayUtil.print(listDeque);
        listDeque.removeAt(1);
        ArrayUtil.print(listDeque);
        listDeque.removeAt(1);
        ArrayUtil.print(listDeque);
        listDeque.removeAt(0);
        ArrayUtil.print(listDeque);

        StdOut.println("Resizing array deque:");
        Deque<String> arrayDeque = new ResizingArrayDeque<>();
        arrayDeque.pushRight("1");
        arrayDeque.pushRight("2");
        arrayDeque.pushRight("3");
        ArrayUtil.print(arrayDeque);
        arrayDeque.removeAt(1);
        ArrayUtil.print(arrayDeque);
        arrayDeque.removeAt(1);
        ArrayUtil.print(arrayDeque);
        arrayDeque.removeAt(0);
        ArrayUtil.print(arrayDeque);
        arrayDeque.pushLeft("2");
        arrayDeque.pushLeft("1");
        arrayDeque.pushRight("3");
        arrayDeque.removeAt(0);
        arrayDeque.removeAt(1);
        arrayDeque.pushRight("4");
        arrayDeque.pushRight("5");
        arrayDeque.pushRight("6");
        ArrayUtil.print(arrayDeque); // 2 4 5 6
        arrayDeque.removeAt(2);
        ArrayUtil.print(arrayDeque); // 2 4 6
    }
}
