package com.mathsEasy;

import java.util.*;

/*
Signed 32 bit integer range is from -2^31 to 2^31 - 1
MAX_VALUE = 2147483647
MIN_VALUE = -2147483648

Input: x = -321
Output: -123

Input: x = 120
Output: 21
 */
public class ReverseInteger {
    public static int reverse(int x){
        int rev = 0;
        while(x != 0){
            int digit = x % 10;
            if(rev > Integer.MAX_VALUE/10 || rev == Integer.MAX_VALUE/10 && digit > 7)
                return 0; // last digit of max value is 7
            if(rev < Integer.MIN_VALUE/10 || rev == Integer.MIN_VALUE/10 && digit < -8)
                return 0; // last digit of min value is -8
            rev = rev * 10 + digit; // might cause overflow so we check for it above
            x /= 10;
        }
        return rev;
    }

    /*
    x = 123
    while(x != 0){
        digit = 3
        rev = 0 * 10 + 3 => 3
        x = 12

        digit = 2
        rev = 3 * 10 + 2 => 32
        x = 1

        digit = 3
        rev = 32 * 10 + 1 => 321
        x = 0
    }
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        System.out.println(reverse(x));
    }
}

/*
If rev = rev * 10 + digit causes overflow, then rev >= MAXVAL/10
(If rev before update is greater than maxval/10, then surely rev after update is greater than maxval itself which would lead to overflow)

i. If rev > MAXVAL/10 then then rev will overflow for sure
ii. If rev == MAXVAL/10 then rev will overflow if last digit of reversed number > 7
 */
