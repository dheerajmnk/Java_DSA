package com.arraysEasy;

import java.util.*;

/*
    Input: nums1 = [1, 2, 3, 0, 0, 0], m = 3, nums2 = [2, 5, 6], n = 3
    Output: [1, 2, 2, 3, 5, 6]
 */
public class MergeSortedArray {
    public static void merge(int [] nums1, int m, int [] nums2, int n){
        // Use 2 pointers from the end to implement merge function
        int [] nums = new int[m + n];
        int left = m - 1;
        int right = n - 1;
        int count = m + n - 1;
        while(left >= 0 && right >= 0){
            if(nums1[left] >= nums2[right]){
                nums1[count--] = nums1[left--];
            }
            else{
                nums1[count--] = nums2[right--];
            }
        }
        while(left >= 0){
            nums1[count--] = nums1[left--];
        }
        while(right >= 0){
            nums[count--] = nums2[right--];
        }
        for(int i = 0; i < nums1.length; i++){
            System.out.print(nums1[i] + " ");
        }
    }

    /*
    while(2>=0 && 2 >= 0){
        nums1[5] = nums2[2] ==> 6
        nums1[4] = nums2[1] ==> 5
        nums1[3] = nums1[2] ==> 3
        nums1[2] = nums1[1] ==> 2
        nums1[1] = nums2[0] ==> 2
    }
    while(0 >= 0){
        nums1[0] = nums1[0]
    }
     */

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int [] nums1 = new int[m + n];
        for(int i = 0; i < m + n; i++) {
            nums1[i] = scan.nextInt();
        }
        int [] nums2 = new int[n];
        for(int i = 0; i < n; i++){
            nums2[i] = scan.nextInt();
        }
        merge(nums1, m, nums2, n);
    }
}
