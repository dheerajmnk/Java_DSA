package com.arraysEasy;

import java.util.*;
/*
    Input: nums = [0, 1, 0, 3, 12]
    Output: [1, 3, 12, 0, 0]
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        /* Using extra array (Use 2 pointers to add all non-zero elements to new array and then add the zeroes)
        int [] arr = new int [nums.length];
        int numsPointer = 0;
        int arrPointer = 0;
        while(numsPointer < nums.length){
            if(nums[numsPointer] != 0){
                arr[arrPointer] = nums[numsPointer];
                arrPointer++;
            }
            numsPointer++;
        }
        for(int i = arrPointer; i < numsPointer; i++){
            arr[i] = 0;
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = arr[i];
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        */

        // Without using extra array (Use a pointer to change the indexes of non-zero elements and fill up the remaining slots with zero)
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[ptr++] = nums[i];
            }
        }
        while (ptr < nums.length) {
            nums[ptr++] = 0;
        }
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    /*
    For loop:
    nums[0] = nums[1] => 1
    nums[1] = nums[3] => 3
    nums[2] = nums[4] => 12
    While loop:
    nums[3] = 0
    nums[4] = 0
     */

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scan.nextInt();
        }
        moveZeroes(nums);
    }
}
