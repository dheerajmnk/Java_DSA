package com.arraysEasy;

import java.util.*;

/*
Input: prices = [7, 1, 5, 3, 6, 4]
Output: 5
(Buy on Day 2 and Sell on Day 5: 6 - 1 = 5)
 */
public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int [] prices){

        /*
        Brute Force: Use 2 loops to find the maximum profit possible, each i'th iteration will find its difference with all the elements ahead of it
        TC: O(n^2), SC: O(1)

        int max = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                int profit = prices[j] - prices[i];
                max = Math.max(max, profit);
            }
        }
        return max;
         */

        /*
        Optimised: Use a single loop to compute maximum profit by computing the difference of current element with minimum value seen so far
        TC: O(n), SC: O(1)
        If input array = [310,315, 275, 295, 260, 270, 290, 230, 255, 250],
        Array of minimum values seen so far = [310, 310, 275, 275, 260, 260, 260, 230, 230, 230] and
        Maximum profit array = [0,5, 0, 20, 0,10,30,0, 25, 20]
         */
        int maxProfit = 0;
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            minVal = Math.min(minVal, prices[i]);
            int profit = prices[i] - minVal;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }

    /* [7, 1, 5, 3, 6, 4]

    i = 0
        minVal = 7, profit = 0, maxProfit = 0
    i = 1
        minVal = 1, profit = 0, maxProfit = 0
    i = 2
        minVal = 1, profit = 4, maxProfit = 4
    i = 3
        minVal = 1, profit = 2, maxProfit = 4
    i = 4
        minVal = 1, profit = 5, maxProfit = 5
    i = 5
        minVal = 1, profit = 3, maxProfit = 5

     */

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] prices = new int[n];
        for(int i = 0; i < n; i++){
            prices[i] = scan.nextInt();
        }
        System.out.println(maxProfit(prices));
    }
}
