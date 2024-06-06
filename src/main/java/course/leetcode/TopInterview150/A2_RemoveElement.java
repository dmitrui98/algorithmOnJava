package course.leetcode.TopInterview150;

import course.leetcode.Utils;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 *
 * Consider the number of elements in nums which are not equal to val be k,
 * to get accepted, you need to do the following things:
 *
 * Change the array nums such that the first k elements of nums contain the elements which
 * are not equal to val. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 */
public class A2_RemoveElement {

    public static void main(String[] args) {
        A2_RemoveElement instance = new A2_RemoveElement();
        instance.go();
        instance.go1();
    }

    /**
     * Input: nums = [3,2,2,3], val = 3
     * Output: 2, nums = [2,2,_,_]
     */
    private void go() {
        int[] nums = {3, 2, 2, 3};
        int k = removeElement(nums, 3);
        System.out.println("k: " + k);
        Utils.printArray(nums);
    }

    /**
     * Input: nums = [0,1,2,2,3,0,4,2], val = 2
     * Output: 5, nums = [0,1,4,0,3,_,_,_]
     */
    private void go1() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int k = removeElement(nums, 2);
        System.out.println("k: " + k);
        Utils.printArray(nums);
    }

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                int j = i;
                while (nums[j] == val) {
                    j++;
                    if (j >= nums.length) {
                        return k;
                    }
                }
                nums[i] = nums[j];
                nums[j] = val;
                k++;
            } else {
                k++;
            }
        }
        return k;
    }
}
