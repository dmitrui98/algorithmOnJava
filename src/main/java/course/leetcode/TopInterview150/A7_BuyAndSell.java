package course.leetcode.TopInterview150;

import course.leetcode.Utils;

/**
 * 121. Best Time to Buy and Sell Stock
 *
 * You are given an array prices where prices[i] is the price of a given stock on the i-th day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */
public class A7_BuyAndSell {

    public static void main(String[] args) {
        A7_BuyAndSell instance = new A7_BuyAndSell();
        instance.go();
        instance.go1();
        instance.go2();
        instance.go3();
        instance.go4();
        instance.go5();
        instance.go6();
        instance.go7();
    }

    /**
     * Input: nums = [7,1,5,3,6,4]
     * Output: 5
     */
    private void go() {
        System.out.println("Тест кейс: ");
        int[] mas = {7,1,5,3,6,4};
        int k = maxProfit(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums = [7,6,4,3,1]
     * Output: 0
     */
    private void go1() {
        System.out.println("Тест кейс: ");
        int[] mas = {7,6,4,3,1};
        int k = maxProfit(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums = [7,2,5,3,6,1,2]
     * Output: 4
     */
    private void go2() {
        System.out.println("Тест кейс: ");
        int[] mas = {7,2,5,3,6,1,2};
        int k = maxProfit(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums = [5,7,2,5,3,6,1,2]
     * Output: 4
     */
    private void go3() {
        System.out.println("Тест кейс: ");
        int[] mas = {5,7,2,5,3,6,1,2};
        int k = maxProfit(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums = [2,7,2,5,3,6,1,2]
     * Output: 5
     */
    private void go4() {
        System.out.println("Тест кейс: ");
        int[] mas = {2,7,2,5,3,6,1,2};
        int k = maxProfit(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums = [7,2,2,2,8,2,2,10,2]
     * Output: 8
     */
    private void go5() {
        System.out.println("Тест кейс: ");
        int[] mas = {7,2,2,2,8,2,2,10,2};
        int k = maxProfit(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums = [3,7,2,5,3,6,1,2,100]
     * Output: 99
     */
    private void go6() {
        System.out.println("Тест кейс: ");
        int[] mas = {3,7,2,5,3,6,1,2,100};
        int k = maxProfit(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums = [4,7,2,1]
     * Output: 3
     */
    private void go7() {
        System.out.println("Тест кейс: ");
        int[] mas = {4,7,2,1};
        int k = maxProfit(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - buyPrice);
            }
        }
        return profit;
    }

    public int maxProfit1(int[] prices) {
        int profit = 0;
        int right = prices.length - 1;
        while (right > 0) {
            int iMin = min(prices, right);
            int iMax = max(prices, iMin, right);
            int p = prices[iMax] - prices[iMin];
            if (p > profit) {
                profit = p;
            }
            right = iMin - 1;
        }
        return profit;
    }

    private int min(int[] a, int right) {
        int min = a[0];
        int iMin = 0;
        for (int i = 1; i <= right; i++) {
            if (a[i] < min) {
                min = a[i];
                iMin = i;
            }
        }
        return iMin;
    }

    private int max(int[] a, int left, int right) {
        int max = a[left];
        int iMax = left;
        for (int i = left + 1; i <= right; i++) {
            if (a[i] > max) {
                max = a[i];
                iMax = i;
            }
        }
        return iMax;
    }
}
