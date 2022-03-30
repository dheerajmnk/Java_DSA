package com.arraysEasy;

import java.util.*;

/*
Same as finding out the prefix array
Input: [1, 2, 3, 4]
Output: [1, 3, 6, 10]
 */

public class RunningSum {
    public static int[] runningSum(int[] nums) {
        // The running sum of an element is the current element plus the sum of all the elements before it

        /* Using extra space
        int [] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum[i] = nums[i] + sum[i - 1];
        }
        return sum;

        sum[0] = nums[0] => 1
        sum[1] = nums[1] + sum[0] = 2 + 1 => 3
        sum[2] = nums[2] + sum[1] = 3 + 3 => 6
        sum[3] = nums[3] + sum[2] = 4 + 6 => 10
         */

        // Without using extra space
        for(int i = 1; i < nums.length; i++){
            nums[i] += nums[i - 1];
        }
        return nums;
        /*
        nums[1] += nums[0] => 2 + 1 => 3
        nums[2] += nums[1] => 3 + 3 => 6
        nums[3] += nums[2] => 10
         */
    }

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] nums = new int[n];
        for(int i = 0; i < n; i++){
           nums[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(runningSum(nums)));
    }
}

/*
Given an array of size n, prefix sum array is another array of size n such that
prefixsum[i] = (a[0] + a[1] + a[2] + ........ + a[i - 1]) + a[i]

prefixsum[i - 1] = a[0] + a[1] + a[2] + .......... + a[i - 1]
prefixsum[i] = prefixsum[i - 1] + a[i]

For a = [10, 20, 10, 5, 15], prefixsum = [10, 30, 40, 45, 60]
 */
