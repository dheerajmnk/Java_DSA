package com.arraysEasy;

import java.util.*;
/*
 Input: nums = [2, 7, 9, 11], target = 9
 Output: nums[0] + nums[1] == 9 so we return [0,1]
 */
public class TwoSum {

    public static int[] twoSum(int [] nums, int target){
    /*
    Brute force: Find all possible pairs and check if their sum is equal to target
    TC: O(n^2) SC: O(1)

        for(int i = 0; i < nums.length - 1; i++){ // length-1 because the single last element cannot give a pair
            for(int j = i + 1; j < nums.length; j++){ // i+1 because we cannot use the same element twice
                if(nums[i] + nums[j] == target){
                    return new int[] {i, j};
                }
            }
        }
        return null;
    */

     /*
     Optimization: Sorting Input array and using two pointers to find a pair with sum equal to target
     Note: Does not work for returning indices because sorting changes the indices
     TC: O(nlogn), SC: O(1)

     Arrays.sort(nums);
     int low = 0;
     int high = nums.length - 1;
     while(low < high){
         if(nums[low] + nums[high] == target){
             return new int[] {low, high};
         }
         else if(nums[low] + nums[high] < target){
             low++;
         }
         else{
             high--;
         }
     }
     return null;
     */

    /* Final Optimization: Throw a hashmap at the problem
       Iterate through the array, find the complement of each number.
       If the completement already exists as a key in the hashmap, return the corresponding index and current index.
       If not, store current number along with current index in the hashmap.
     TC: O(n), SC: O(n) */
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i <  nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                // the solution is found in the second run of the loop, not the first, so the values are reversed from what you would expect
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /* [2, 7, 9, 11], 9

    i = 0
        complement = 9 - 2 = 7;
        map.put(2, 0) (K, V)

    i = 1
        complement = 9 - 7 = 2;
        if(map.containsKey(2)){
            return new int[] {map.get(2), 1} ie {0, 1}; (0 is the value mapped at key 2)
         }

    */

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scan.nextInt();
        }
        int target = scan.nextInt();
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
