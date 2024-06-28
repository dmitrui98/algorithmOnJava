package course.ulbiTV;

import util.ArrayUtil;

/**
 * Сложность O(n)
 */
public class A1_SearchLiner {
    private static int countLiner = 0;

    public static void main(String[] args) {
        A1_SearchLiner search = new A1_SearchLiner();
        int[] a = {1,4,5,8,5,1,2,7,5,2,11};
        ArrayUtil.printArray(a);
        int searchItem = 222;
        Integer index = search.searchLiner(a, searchItem);
        System.out.printf("Search item: %s; index: %s; countIterations: %s", searchItem, index, countLiner);
    }

    private Integer searchLiner(int[] a, int item) {
        countLiner = 0;
        for (int i = 0; i < a.length; i++) {
            countLiner++;
            if (a[i] == item) {
                return i;
            }
        }
        return null;
    }
}
