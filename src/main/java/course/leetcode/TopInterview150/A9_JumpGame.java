package course.leetcode.TopInterview150;

import util.ArrayUtil;

/**
 * 55. Jump Game
 *
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 */
public class A9_JumpGame {

    public static void main(String[] args) {
        new A9_JumpGame().go();
    }

    private void go() {
        int[] a;
        // Jump 1 step from index 0 to 1, then 3 steps to the last index.
        a = new int[]{2,3,1,1,4}; // true
        ArrayUtil.printArray(a);
        System.out.println("Can jump: " + canJump(a));

        // You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
        a = new int[]{3,2,1,0,4}; // false
        ArrayUtil.printArray(a);
        System.out.println("Can jump: " + canJump(a));

        a = new int[]{1,1,1,0}; // true
        ArrayUtil.printArray(a);
        System.out.println("Can jump: " + canJump(a));

        a = new int[]{1,1,2,2,0,1,1}; // true
        ArrayUtil.printArray(a);
        System.out.println("Can jump: " + canJump(a));


        a = new int[]{7,2,3,2,6,0,0,1,0,1,0}; // true
        ArrayUtil.printArray(a);
        System.out.println("Can jump: " + canJump(a));

        a = new int[]{5,9,3,2,1,0,2,3,3,1,0,0}; // true
        ArrayUtil.printArray(a);
        System.out.println("Can jump: " + canJump(a));
    }

    public boolean canJump(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int maxSteps = nums[i];
            int j = i + 1;
            int step = 1;
            int path = nums[i];
            int jumpIndex = i;
            while (step <= maxSteps && j < nums.length) {
                int jump = nums[j] + step;
                if (path < jump) {
                    path = jump;
                    jumpIndex = j;
                }
                j++;
                step++;
            }
            if (path + i >= nums.length - 1) {
                return true;
            }
            if (jumpIndex == i) {
                return false;
            }
            i = jumpIndex;
        }
        return false;
    }
}
