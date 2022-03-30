package com.arraysEasy;

import java.util.*;

/*
F(0) = 0, F(1) = 1
F(n) = F(n-1) + F(n-2}
Input: n = 4
Output: 3
 */
public class FibonacciNumber {
    public static int fib(int n){
        /* Recursive Approach
        Top to bottom and then bottom to top, same computations are done multiple times
        TC: O(2^n), SC:O(n) for recursive function call stack
        if(n < 2){
            return n;
        }
        return fib(n-1) + fib(n-2);
         */

        /* Iterative Approach
        Store the sum of previous 2 nums in res, store n-1th num in n-2th pos and nth num in n-1th pos
        TC: O(n), SC: O(1)
        if(n < 2){
            return n;
        }
        int first = 0;
        int second = 1;
        int res = 0;
        for(int i = 2; i <= n; i++){
            res = first + second;
            first = second;
            second = res;
        }
        return res;
        */

        // Bottom-up Dynamic Programming
        // Memoization: Technique used for DP questions/within DP solutions
        // Store results calculated in past so we dont have to calculate them again
        // TC: O(n), SC: O(n)
        if(n < 2){
            return n;
        }
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /*
    dp[2] = dp[1] + dp[0] = 1 + 0 => 1
    dp[3] = dp[2] + dp[1] = 1 + 1 => 2
    dp[4] = dp[3] + dp[2] = 2 + 1 => 3
    dp = [0, 1, 1, 2, 3]
     */

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(fib(n));
    }
}
