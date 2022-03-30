package com.arraysEasy;

import java.util.*;
/*
Pivot index is same as finding equilibrium index in an array
Sum of elements on left = Sum of elements on right (Strictly = excluding current element)
Input: nums = [1, 7, 3, 6, 5, 6]
Output: 3
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 6 + 5  = 11
 */
public class PivotIndex {

    public static int pivotIndex(int[] nums){
        /*
        Brute force: Iterate through the array and compute leftsum & rightsum for each iteration O(n^2)
        for(int i = 0; i < nums.length; i++){
            int lsum = 0;
            for(int j = 0; j < i; j++){
                lsum += nums[j];
            }
            int rsum = 0;
            for(int j = i; j < nums.length; j++){
                rsum += nums[j];
            }
            if(lsum == rsum){
                return i;
            }
        }
        return -1;
        */

        // Optimized approach: Compute total sum of array, keep subtracting ith element from sum and adding it to leftsum O(n)
        // Use the fact that rightsum = sum - a[i];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        int lsum = 0;
        for(int i = 0; i < nums.length; i++){
            sum -= nums[i];
            if(lsum == sum){
                return i;
            }
            lsum += nums[i];
        }
        return -1;
    }

    /*
    sum = 28
    i = 0
        sum = 27, lsum = 1
    i = 1
        sum = 20, lsum = 8
    i = 2
        sum = 17, lsum = 11
    i = 3
        sum = 11, return 3
     */

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scan.nextInt();
        }
        System.out.println(pivotIndex(nums));
    }
}
