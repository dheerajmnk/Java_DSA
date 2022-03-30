package com.arraysEasy;

import java.util.*;

/*
Input: nums = [-4, -1, 0, 3, 10]
Output: [0, 1, 9, 16, 100]
 */
public class SquaresOfSortedArray {
    public static int[] sortedSquares(int[] nums) {
        /* Brute Force: Square the array and then sort it
        TC: O(nlogn), SC: O(1)
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
        */

        // Optimized Approach
        ArrayList<Integer> negArr = new ArrayList<>();
        ArrayList<Integer> posArr = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                negArr.add(nums[i] * nums[i]);
            }
            else{
                posArr.add(nums[i] * nums[i]);
            }
        }
        Collections.reverse(negArr);
        int [] res = new int[nums.length];
        int negSize = negArr.size();
        int posSize = posArr.size();
        int neg = 0;
        int pos = 0;
        int count = 0;
        while(neg < negSize && pos < posSize){
            if(negArr.get(neg) <= posArr.get(pos)){
                res[count++] = negArr.get(neg++);
            }
            else{
                res[count++] = posArr.get(pos++);
            }
        }
        while(neg < negSize){
            res[count++] = negArr.get(neg++);
        }
        while(pos < posSize){
            res[count++] = posArr.get(pos++);
        }
        return res;
    }

    /*
    negArr = [16, 1] =====> [1, 16] (Reverse)
    posArr = [0, 9, 100]
    while(0 < 2 && 0 < 3){
        res[0] = posArr[0] => 0
        res[1] = negArr[0] => 1
        res[2] = posArr[1] => 9
        res[3] = negArr[1] => 16
    }
    while(2 < 3){
        res[4] = posArr[2] => 100
    }
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
}

