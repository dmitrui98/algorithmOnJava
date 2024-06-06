package course.leetcode.TopInterview150;

import course.leetcode.Utils;

import java.util.Arrays;

/**
 * 169. Majority Element
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than n / 2 times.
 * You may assume that the majority element always exists in the array.
 */
public class A5_MajorityElement {

    public static void main(String[] args) {
        A5_MajorityElement instance = new A5_MajorityElement();
        instance.go();
        instance.go1();
        instance.go2();
        instance.go3();
        instance.go4();
    }

    /**
     * Input: nums = [3,2,3]
     * Output: 3
     */
    private void go() {
        System.out.println("Тест кейс: ");
        int[] mas = {3,2,3};
        int k = majorityElement(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     */
    private void go1() {
        System.out.println("Тест кейс: ");
        int[] mas = {2,2,1,1,1,2,2};
        int k = majorityElement(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums = [6,5,5]
     * Output: 5
     */
    private void go2() {
        System.out.println("Тест кейс: ");
        int[] mas = {6,5,5};
        int k = majorityElement(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums = [7,5,1,5,7,5,0,5,5]
     * Output: 5
     */
    private void go3() {
        System.out.println("Тест кейс: ");
        int[] mas = {7,5,1,5,7,5,0,5,5};
        int k = majorityElement(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums = [3,6,6,1,1,1,6,6,6]
     * Output: 6
     */
    private void go4() {
        System.out.println("Тест кейс: ");
        int[] mas = {3,6,6,1,1,1,6,6,6};
        int k = majorityElement(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    public int majorityElement(int[] nums) {
        int m = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                m = num;
            }
            if (num == m) {
                count++;
            } else {
                count--;
            }
        }
        return m;
    }

    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {
        int result = nums[0];
        int maxCount = 1;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                result = nums[i];
            }
        }
        return result;
    }
}
