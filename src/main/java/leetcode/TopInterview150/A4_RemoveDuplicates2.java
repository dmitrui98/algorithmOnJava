package leetcode.TopInterview150;

import leetcode.Utils;

/**
 * 80. Remove Duplicates from Sorted Array II
 *
 * Given an integer array nums sorted in non-decreasing order,
 * remove some duplicates in-place such that each unique element appears at most twice.
 * The relative order of the elements should be kept the same.
 *
 * Return k after placing the final result in the first k slots of nums.
 */
public class A4_RemoveDuplicates2 {

    public static void main(String[] args) {
        A4_RemoveDuplicates2 instance = new A4_RemoveDuplicates2();
        instance.go();
        instance.go1();
        instance.go2();
        instance.go3();
        instance.go4();
    }

    /**
     * Input: nums = [1,1,1,2,2,3]
     * Output: 5, nums = [1,1,2,2,3,_]
     */
    private void go() {
        System.out.println("Тест кейс: ");
        int[] mas = {1,1,1,2,2,3};
        int k = removeDuplicates(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums = [0,0,1,1,1,1,2,3,3]
     * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
     */
    private void go1() {
        System.out.println("Тест кейс: ");
        int[] mas = {0,0,1,1,1,1,2,3,3};
        int k = removeDuplicates(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums = [0,1,2,3,4,5,6]
     * Output: 7, nums = [0,1,2,3,4,5,6]
     */
    private void go2() {
        System.out.println("Тест кейс: ");
        int[] mas = {0,1,2,3, 4, 5, 6};
        int k = removeDuplicates(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums: [0,1,1,2,3,3,3,4,4,5,6,6,6,6,6,7,7,7,8,10,10,11]
     * Output: 17, nums = [0,1,1,2,3,3,4,4,5,6,6,7,7,8,10,10,11,_]
     */
    private void go3() {
        System.out.println("Тест кейс: ");
        int[] mas = {0,1,1,2,3,3,3,4,4,5,6,6,6,6,6,7,7,7,8,10,10,11};
        int k = removeDuplicates(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums: [0,0,0,1,1,2,3,3,3,4,4,5,6,6,6,6,6,7,7,7,8,10,10,11,11,11,11,11]
     * Output: 19, nums = [0,0,1,1,2,3,3,4,4,5,6,6,7,7,8,10,10,11,11,_]
     */
    private void go4() {
        System.out.println("Тест кейс: ");
        int[] mas = {0,0,0,1,1,2,3,3,3,4,4,5,6,6,6,6,6,7,7,7,8,10,10,11,11,11,11,11};
        int k = removeDuplicates(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        int k = 0;
        while (i < nums.length) {
            int j = i;
            boolean twoElements = false;
            while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                j++;
                twoElements = true;
            }
            nums[k++] = nums[j];
            if (twoElements) {
                nums[k++] = nums[j];
            }
            i = j + 1;
        }
        return k;
    }

    public int removeDuplicates1(int[] nums) {
        int i = 0;
        int l = 0;
        int count = 0;
        while (i < nums.length) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                if (count > 0) { // больше двух элементов слева
                    count = 0;
                    int j = i;
                    while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    nums[l++] = nums[j];
                    int j1 = j + 1;
                    int count2 = 0;
                    while (j1 < nums.length - 1 && nums[j1] == nums[j1 + 1]) {
                        j1++;
                        count2++;
                    }
                    if (count2 > 0) {
                        nums[l++] = nums[j1];
                        nums[l++] = nums[j1];
                    } else if (j1 < nums.length) {
                        nums[l++] = nums[j1];
                    }
                    i = j1 + 1;
                } else {
                    nums[l++] = nums[i++];
                    count++;
                }
            } else {
                count = 0;
                nums[l++] = nums[i++];
            }
        }
        return l;
    }
}
