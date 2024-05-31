package leetcode.TopInterview150;

import leetcode.Utils;

/**
 * 26. Remove Duplicates from Sorted Array
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates
 * in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * Then return the number of unique elements in nums.
 */
public class A3_RemoveDuplicates {

    public static void main(String[] args) {
        A3_RemoveDuplicates instance = new A3_RemoveDuplicates();
//        instance.go();
        instance.go1();
//        instance.go2();
//        instance.go3();
    }

    private void go() {
        System.out.println("Тест кейс: ");
        int[] mas = {1, 2, 3, 3, 3, 3, 8, 8, 8, 9, 10, 10, 12};
        int k = removeDuplicates(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    private void go1() {
        System.out.println("Тест кейс: ");
        int[] mas = {1, 1};
        int k = removeDuplicates(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    private void go2() {
        System.out.println("Тест кейс: ");
        int[] mas = {1, 1, 2};
        int k = removeDuplicates(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    private void go3() {
        System.out.println("Тест кейс: ");
        int[] mas = {0,0,1,1,1,2,2,3,3,4};
        int k = removeDuplicates(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    public int removeDuplicates(int[] nums) {
        int i = 1;
        int l = 1;
        while (i < nums.length) {
            while (i < nums.length && nums[i-1] == nums[i]) {
                i++;
            }
            if (i < nums.length) {
                nums[l++] = nums[i++];
            }
        }
        return l;
    }
}
