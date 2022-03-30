package com.arraysEasy;

import java.util.*;

/*
Note: Only one stock can be held at any given time so after buy there must be a sell
Input: prices = [7, 1, 5, 3, 6, 8]
Output: 9
(Buy on Day 2 and Sell on Day 3: 5-1 = 4)
(Buy on Day 4 and Sell on Day 6: 8 - 3 = 5)
(4 + 5 = 9)
 */
public class BestTimeToBuyAndSellStock2 {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1]){
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    /*
    i = 1
    Condition fails
    i = 2 (5 > 1)
    profit += 5 - 1 => 4
    i = 3
    Condition fails
    i = 4 (6 > 3)
    profit += 6 - 3 => 3
    i = 5 (8 > 6)
    profit += 8 - 6 => 2
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
