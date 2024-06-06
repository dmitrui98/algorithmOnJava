package course.leetcode.TopInterview150;

import course.leetcode.Utils;

/**
 * 189. Rotate Array
 *
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 * Follow up:
 * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class A6_RotateArray {

    public static void main(String[] args) {
        A6_RotateArray instance = new A6_RotateArray();
        instance.go();
        instance.go1();
        instance.go2();
    }

    /**
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     */
    private void go() {
        System.out.println("Тест кейс: ");
        int[] mas = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(mas, k);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums = [-1,-100,3,99], k = 2
     * Output: [3,99,-1,-100]
     */
    private void go1() {
        System.out.println("Тест кейс: ");
        int[] mas = {-1,-100,3,99};
        int k = 2;
        rotate(mas, k);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums = [1,2,3,4,5,6,7,8,9,10,11], k = 10
     * Output: [2,3,4,5,6,7,8,9,10,11,1]
     */
    private void go2() {
        System.out.println("Тест кейс: ");
        int[] mas = {1,2,3,4,5,6,7,8,9,10,11};
        int k = 10;
        rotate(mas, k);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] a = new int[n];
        int l = n - k;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (l < nums.length) {
                a[i] = nums[l++];
            } else {
                a[i] = nums[j++];
            }
        }
        System.arraycopy(a, 0, nums, 0, nums.length);
    }

    /**
     * The same as rotate3
     */
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int[] a = new int[nums.length];
        int left = k - 1;
        int right = k;
        for (int i = 0, j = nums.length - 1; left >= 0 || right < nums.length; i++, j--) {
            if (left >= 0) {
                a[left--] = nums[j];
            }
            if (right < nums.length) {
                a[right++] = nums[i];
            }
        }
        System.arraycopy(a, 0, nums, 0, nums.length);
    }

    /**
     * Не прошло по времени
     */
    public void rotate1(int[] nums, int k) {
        int k1 = k % nums.length;
        for (int i = 0; i < k1; i++) {
            int prev = nums[0];
            for (int j = 1; j < nums.length; j++) {
                int tmp = nums[j];
                nums[j] = prev;
                prev = tmp;
            }
            nums[0] = prev;
        }
    }
}
