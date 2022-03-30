package com.misc;

import java.util.Scanner;

public class MergeFunction {

    public static void merge(int [] nums1, int m, int [] nums2, int n){
        int [] nums = new int[m + n];
        int left = 0;
        int right = 0;
        int count = 0;
        while(left < m && right < n){
            if(nums1[left] <= nums2[right]){
                nums[count++] = nums1[left++];
            }
            else{
                nums[count++] = nums2[right++];
            }
        }
        while(left < m){
            nums[count++] = nums1[left++];
        }
        while(right < n){
            nums[count++] = nums2[right++];
        }
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int [] nums1 = new int[m];
        for(int i = 0; i < m; i++) {
            nums1[i] = scan.nextInt();
        }
        int n = scan.nextInt();
        int [] nums2 = new int[n];
        for(int i = 0; i < n; i++){
            nums2[i] = scan.nextInt();
        }
        merge(nums1, m, nums2, n);
    }
}
