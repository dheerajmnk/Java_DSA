package com.mathsEasy;

import java.util.*;

/*
In one move, we should increment all n - 1 elements by 1 (if the array has 3 elements, we should increment any 2 elements by 1)
Input: nums = [1, 2, 3, 4]
Output: 6
[1, 2, 3, 4] => [2, 3, 4, 4] => [3, 4, 5, 4] => [4, 5, 5, 5] => [5, 6, 6, 5] => [6, 7, 6, 6] => [7, 7, 7, 7]
 */
public class MinimumMovestoEqualArrayElements {
    public static int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            min = Math.min(min, nums[i]);
            sum += nums[i];
        }
        return sum - min * nums.length;
    }

    /*
    length (n) = 4
    min = 1
    sum = 10
    return sum - (min*n) => 10 - 4 => 6

    All numbers are equal in the end. Let the final equal number be x.
    Minimum value always remains minimum until it reaches this final number x.
    So we can say that it is incremented in every move m.

    Minimum number + number of moves = Final number
    min + m = x

    Total sum in the end is final number multiplied by length of array.
    x * n = Total sum -> 1

    We can also increment all (n - 1) elements by 1 for m times and add it to initial sum to get total sum.
    Initial sum + (n - 1)m = Total sum -> 2

    x * n = sum + (n - 1)m
    (min + m) * n = sum + (n - 1)m
    min * n + m * n = sum + (n - 1)m
    min * n + m * n = sum + m * n - m
    min * n = sum - m
    m = sum - min * n
    */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] nums = new int[n];
        for(int i = 0; i < nums.length; i++){
            nums[i] = scan.nextInt();
        }
        System.out.println(minMoves(nums));
    }
}
