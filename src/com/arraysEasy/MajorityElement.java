package com.arraysEasy;

import java.util.*;

/*
Majority element is the element that appears more than n/2 times in an array of size n
Input: [2, 2, 1, 1, 1, 2, 2]
Output: 2
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
    /* Brute Force: Iterate n times for n elements, maintain a count each time and return nums[i] if the count exceeds n/2 length
    TC: O(n^2), SC: O(1)

    for(int i = 0; i < nums.length; i++){
        int count = 0;
        for(int j = i; j < nums.length; j++){
            if(nums[i] == nums[j]){
                count++;
            }
            if(count > nums.length/2){
                return nums[i];
            }
        }
    }
    return -1;
    */

    /* Sort the array and return the number at n/2th index
    TC: O(nlogn), SC:O(1)

        Arrays.sort(nums);
        return nums[nums.length/2];
    */

        /* Throw a hashmap at the problem
        If key does not exist in the map, insert it with value mapped to 1.
        If key exists in the map, increment its mapped value by 1.
        TC: O(n), SC: O(n) {2=4, 1=3}

        HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                if(map.containsKey(nums[i])){
                    map.put(nums[i], map.get(nums[i]) + 1);
                }
                else{
                    map.put(nums[i], 1);
                }
                System.out.println(map);
                if(map.get(nums[i]) > nums.length/2){
                    return nums[i];
                }
            }
        return -1;
        */

        // Moore's Voting Algorithm
        // Assume the answer to be at 0th index and give it a count of 1
        // Iterate through the array, increment count if a[i] == a[ansIndex] and decrement if not
        // Once count reaches 0, change answeridex to i and count to 1
        // Return the element at ansIndex after completing the iteration
        int ansIndex = 0;
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[ansIndex]){
                count++;
            }
            else{
                count--;
            }
            if(count == 0){
                ansIndex = i;
                count = 1;
            }
        }
        return nums[ansIndex];
    }

    /*
    ansIndex = 0
    count = 1
        i = 1
            2 = 2, count++;
        i = 2
            1 != 2, count--
        i = 3
            1 != 2, count --
            ansIndex = 3, count = 1
        i = 4
            1 = 1, count++
        i = 5
            2 != 1, count--
        i = 6
            2 != 1, count--
            ansIndex = 6, count = 1
     */

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] nums = new int[n];
        for(int i = 0; i < nums.length; i++){
            nums[i] = scan.nextInt();
        }
        System.out.println(majorityElement(nums));
    }
}
