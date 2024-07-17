package course.leetcode.TopInterview150;

import course.leetcode.Utils;

/**
 * ### Not solved :-(
 * ### Need to think
 *
 * 122. Best Time to Buy and Sell Stock II
 *
 * You are given an integer array prices where prices[i] is the price of a given stock on the i-th day.
 * On each day, you may decide to buy and/or sell the stock.
 * You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Total profit is 4.
 * Example 3:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 */
public class A8_BuyAndSell2 {

    public static void main(String[] args) {
        A8_BuyAndSell2 instance = new A8_BuyAndSell2();
        instance.go();
        instance.go1();
        instance.go2();
        instance.go3();
        instance.go4();
        instance.go5();
    }

    /**
     * Input: nums = [7,1,5,3,6,4]
     * Output: 7
     */
    private void go() {
        System.out.println("Тест кейс: ");
        int[] mas = {7,1,5,3,6,4};
        int k = maxProfit(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums = [1,2,3,4,5]
     * Output: 4
     */
    private void go1() {
        System.out.println("Тест кейс: ");
        int[] mas = {1,2,3,4,5};
        int k = maxProfit(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums = [7,6,4,3,1]
     * Output: 0
     */
    private void go2() {
        System.out.println("Тест кейс: ");
        int[] mas = {7,6,4,3,1};
        int k = maxProfit(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums = [7,2,80,5,1,70]
     * Output: 147
     */
    private void go3() {
        System.out.println("Тест кейс: ");
        int[] mas = {7,2,80,5,1,70};
        int k = maxProfit(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums = [7,1,2,3,80,4]
     * Output: 79
     */
    private void go4() {
        System.out.println("Тест кейс: ");
        int[] mas = {7,1,2,3,80,4};
        int k = maxProfit(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * Input: nums = [7,1,2,4,80,4]
     * Output: 79
     */
    private void go5() {
        System.out.println("Тест кейс: ");
        int[] mas = {7,1,2,4,80,4};
        int k = maxProfit(mas);
        System.out.println("k: " + k);
        Utils.printArray(mas);
    }

    /**
     * We can use a separate state to tell if we can buy or sell.
     * If we sell/buy then we add its cost to the ans and change the value of the
     * 'canbuy' variable when calling the previous state and and if we dont
     * buy then we just call the value of the previous state .
     * we take the max of both values.
     * Similarly we calculate for other value of canbuy
     *
     * dp[i][canbuy]->states the maximum profit we can get from i..n-1 if our current
     * index is i and our current state if we can buy or sell is represented by 'canbuy'
     */
    public int maxProfit(int[] prices) {
        int[][] profitArray = new int[prices.length + 1][2];
        for (int i = prices.length - 1; i >= 0; i--) {
           for (int canbuy = 0; canbuy <= 1; canbuy++) {
               if (canbuy == 1) {
                   profitArray[i][canbuy] = Math.max(profitArray[i + 1][0] - prices[i], profitArray[i + 1][1]);
               } else {
                   profitArray[i][canbuy] = Math.max(profitArray[i + 1][1] + prices[i], profitArray[i + 1][0]);
               }
           }
        }
        return profitArray[0][1];
    }


    /**
     * Жадный алгоритм: как доказать, что его можно применять????
     */
    public int maxProfitGreetingAlgo(int[] prices) {
        int start = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > start) {
                profit += prices[i] - start;
            }
            start = prices[i];
        }
        return profit;
    }
}
