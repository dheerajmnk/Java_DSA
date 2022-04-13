package com.mathsEasy;

import java.util.*;

/*
Input: 121
Output: true
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        /* Converting given integer to string

        String str = Integer.toString(x);
        int left = 0;
        int right = str.length() - 1;
        while(left <= right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
         */

        // Without converting given integer to a string (Reverse the number and compare with original number)
        if(x < 0){
            return false;
        }
        int num = x;
        int rev = 0;
        while(num != 0){
            int digit = num % 10;
            rev = rev * 10 + digit;
            num /= 10;
        }
        return x == rev;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        System.out.println(isPalindrome(x));
    }
}
