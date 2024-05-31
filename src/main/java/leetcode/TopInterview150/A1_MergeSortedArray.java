package leetcode.TopInterview150;

import leetcode.Utils;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements
 * that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 *
 */
public class A1_MergeSortedArray {

    public static void main(String[] args) {
        A1_MergeSortedArray instance = new A1_MergeSortedArray();
        instance.go();
        instance.go1();
        instance.go2();
    }

    /**
     * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * Output: [1,2,2,3,5,6]
     */
    private void go() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        Utils.printArray(nums1);
    }

    /**
     * Input: nums1 = [1], m = 1, nums2 = [], n = 0
     * Output: [1]
     */
    private void go1() {
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;
        merge(nums1, m, nums2, n);
        Utils.printArray(nums1);
    }

    /**
     * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
     * Output: [1]
     */
    private void go2() {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        merge(nums1, m, nums2, n);
        Utils.printArray(nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int countInput = 0;
        for (int i = 0, j = 0; i < nums1.length && j < n; i++, j++) {
            int border = m + countInput;
            while (nums1[i] < nums2[j] && i < border) {
                i++;
            }
            if (i < border) {
                inputWithShift(nums1, i, nums2[j]);
                countInput++;
            } else {
                for (int k = border; k < m + n; k++, j++) {
                    nums1[k] = nums2[j];
                }
            }
        }
    }

    private void inputWithShift(int[] mas, int index, int n) {
        for (int i = index; i < mas.length; i++) {
            int tmp = mas[i];
            mas[i] = n;
            n = tmp;
        }
    }
}
