package course.leetcode.TopInterview150;

import java.util.Arrays;

/**
 * 238. Product of Array Except Self
 * <br/>
 * Given an integer array nums, return an array answer such that answer[i]
 * is equal to the product of all the elements of nums except nums[i].
 * <br/>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * 2 <= `nums.length` <= 10^5
 * -30 <= nums[i] <= 30
 */
public class A13_ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        new A13_ProductOfArrayExceptSelf().go();
    }

    private void go() {
        int[] array;
        int[] result;

        array = new int[] {8, 2, 3, 4};
        result = productExceptSelf(array);
        assert Arrays.equals(result, new int[]{24, 96, 64, 48});

        array = new int[] {-1, 1, 0, -3, 3};
        result = productExceptSelf(array);
        assert Arrays.equals(result, new int[]{0, 0, 9, 0, 0});

        array = new int[] {8, 2, 3, 4, 5, 6, 7};
        result = productExceptSelf(array);
        assert Arrays.equals(result, new int[]{5040, 20160, 13440, 10080, 8064, 6720, 5760});

        array = new int[] {1, 2, 3, 4, 5, 6, 7};
        result = productExceptSelf(array);
        assert Arrays.equals(result, new int[]{5040, 2520, 1680, 1260, 1008, 840, 720});

        array = new int[] {1, 2, 3, 4};
        result = productExceptSelf(array);
        assert Arrays.equals(result, new int[]{24, 12, 8, 6});
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = 1;
        suffix[n - 1] = 1;
        for (int i = 1, j = n - 2; i < n && j >= 0; i++, j--) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
            suffix[j] = suffix[j + 1] * nums[j + 1];
        }
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }

    public int[] productExceptSelf1(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
        }
        int productLeft = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] *= productLeft;
            productLeft *= nums[i];
        }
        int productRight = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= productRight;
            productRight *= nums[i];
        }
        return result;
    }
}
