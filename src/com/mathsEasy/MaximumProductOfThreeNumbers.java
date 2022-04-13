package com.mathsEasy;


import java.util.*;

/*
Find 3 numbers whose product is maximum and return the maximum product
Input: nums = [1, 2, 3, 4]
Output: 24

According to given constraints, length of nums will always be equal to or greater than 3
 */
public class MaximumProductOfThreeNumbers {
    public static int maximumProduct(int[] nums) {
    /*
    Sorting approach
    The maximum product is either a product of the last 3 values or a product of the last value with the product of first 2 values
    int n = nums.length;
    Arrays.sort(nums);
    return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 3]);
    */

    // Optimized answer in single array traversal
    // Instead of sorting the array, we can just find the necessary values needed to compute the maximum product.
    // The necessary values are the 2 smallest values (min1, min2) and the 3 largest values (max1, max2, max3)
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= min1){
                min2 = min1;
                min1 = nums[i];
            }
            else if(nums[i] <= min2){ // nums[i] lies between min1 and min2
                min2 = nums[i];
            }

            if(nums[i] >= max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }
            else if(nums[i] >= max2){ // nums[i] lies between max1 and max2
                max3 = max2;
                max2 = nums[i];
            }
            else if(nums[i] >= max3){ // nums[i] lies between max2 and max3
                max3 = nums[i];
            }
        }
        return Math.max(min1 * min2 * max1, max3 * max2 * max1);
    }

    /*
    Negative numbers may also be present in the given input array.

    Consider sorted array nums = [-2, -1, 3, 4, 5]
    Here we get maximum product simply by using the last 3 values
    3 * 4 * 5 = 60 which is nums[n-3] * nums[n-2] * nums[n-1]

    Now consider sorted array nums = [-8, -7, -6, 2, 5]
    Here using the last 3 values would not produce the maximum product.
    Considering all the first 3 values would make the total product negative which cannot be the maximum product.
    Instead we rely on the first 2 values to be multiplied to produce a positive value which is then multiplied with the last value in array.
    -8 * -7 * 5 = 280 which is nums[0] * nums[1] * nums[n-1]


    Maximum product = Max(min1 * min2 * max1, max3 * max2 * max1)

    Find these values in single traversal
    Eg: nums = [-2, -3, 1, -5,  6, 4, 5]

Finding min1 and min2

    if(-2 <= MAXVAL){
        min2 = MAXVAL
        min1 = -2
    }

    if(-3 <= -2){
        min2 = -2
        min1 = -3
    }

    1 is not lesser than -3 and -2

    if(-5 <= -3){
        min2 = -3
        min1 = -5
    }

Therefore min2 = -3 and min1 = -5

Finding max1, max2 and max3

    if(-2 >= MINVAL){
        max3 = MINVAL
        max2 = MINVAL
        max1 = -2
    }

    -3 is not greater than -2 but it is greater than MINVAL
    else if(-3 >= MINVAL){
        max3 = MINVAL
        max2 = -3
    }

    if(1 >= -2){
        max3 = -3
        max2 = -2
        max1 = 1
    }

    -5 is not greater than max1, max2 and max3

    if(6 >= 1){
        max3 = -2
        max2 = 1
        max1 = 6
    }

   4 is not greater than 6 but it is greater than 1
   else if(4 >= 1){
        max3 = 1
        max2 = 4
   }

   5 is not greater than 6 but it is greater than 4
   else if(5 >= 4){
        max3 = 4
        max2 = 5
   }

Therefore max1 = 6, max2 = 5 and max3 = 4
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] nums = new int [n];
        for(int i = 0; i < n; i++){
            nums[i] = scan.nextInt();
        }
        System.out.println(maximumProduct(nums));
    }
}
