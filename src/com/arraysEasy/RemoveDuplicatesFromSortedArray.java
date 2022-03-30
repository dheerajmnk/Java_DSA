package com.arraysEasy;

import java.util.*;

/*
Do not allocate extra space. Return k after placing the final result in the first k slots of nums.
Input: nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
Output: 5 ==> nums = [0, 1, 2, 3, 4, _, _, _, _, _]
 */

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        /* Using extra space: Store unique elements in a hashset and add them into nums array
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int k = set.size();
        int count = 0;
        for(int x: set){
            nums[count++] = x;
        }
        return k;
         */

        // Without using extra space: Use slow pointer and incremental pointer
        // When nums[ptr] = nums[i], increment i to skip the duplicates
        // When nums[ptr] != nums[i], increment ptr and i, copy the value at nums[i] to nums[ptr]
        int ptr = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[ptr] != nums[i]){
                ptr++;
                nums[ptr] = nums[i];
            }
        }
        return ptr + 1;
    }

/*
ptr = 0
i = 1
    0 == 0
i = 2
    0 != 1
    ptr++
    nums[1] = 1
i = 3
    1 == 1
i = 4
    1 == 1
i = 5
    i != 2
    ptr++
    nums[2] = 2
i = 6
    2 == 2
i = 7
    2 != 3
    ptr++
    nums[3] = 3
i = 8
    3 == 3
i = 9
    3 != 4
    ptr++
    nums[4] = 4
return 5
 */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] nums = new int [n];
        for(int i = 0; i < nums.length; i++){
            nums[i] = scan.nextInt();
        }
        System.out.println(removeDuplicates(nums));
    }
}
