package lesson3;

import common.data.structure.bag.RandomBag;

/**
 * Exercise 1.3.34
 * Implement RandomBag {@link common.data.structure.util.base.BagInterface}
 */
public class B11_RandomBag {

    public static void main(String[] args) {
        RandomBag<Integer> randomBag = new RandomBag<>();
        randomBag.add(1);
        randomBag.add(2);
        randomBag.add(3);
        randomBag.add(10);
        randomBag.add(20);
        randomBag.add(8);
        randomBag.add(30);
        randomBag.add(7);
        for (Integer item : randomBag) {
            System.out.print(item + " ");
        }
        System.out.println();
        for (Integer item : randomBag) {
            System.out.print(item + " ");
        }
        System.out.println();
        for (Integer item : randomBag) {
            System.out.print(item + " ");
        }
    }
}
