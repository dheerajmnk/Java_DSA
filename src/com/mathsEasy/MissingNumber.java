package com.mathsEasy;

import java.util.*;

/*
Array consists of n distinct numbers in the range [0, n].
Input: nums = [9, 6, 4, 2, 3, 5, 7, 0, 1]
Output: 8
Explanation: n = 9 since there are 9 numbers. They are in the range [0, 9] and 8 is missing
 */
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int givenArrSum = 0;
        for(int i = 0; i < nums.length; i++){
            givenArrSum += nums[i];
        }
        int missingIncludedSum = nums.length * (nums.length + 1)/2;
        return missingIncludedSum - givenArrSum;
    }

    /*
    We know that sum of all elements from 0 to n is n * (n+1) / 2
    For example, 0 + 1 + 2 + 3 + 4 = (4 * 5)/2 => 10 = 10

    We are given the sum of all numbers excluding the missing number

    Sum of given array + Missing number = Sum of all elements from 0 to n

    Sum of given array = 9 + 6 + 4 + 2 + 3 + 5 + 7 + 0 + 1 = 37
    Sum of all elements from 0 to 9 = (9*10)/2 = 90/2 = 45

    37 + Missing number = 45
    Missing number = 45 - 37
    Missing number = 8
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] nums = new int [n];
        for(int i = 0; i < n; i++){
            nums[i] = scan.nextInt();
        }
        System.out.println(missingNumber(nums));
    }
}
