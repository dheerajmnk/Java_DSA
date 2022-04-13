package com.mathsEasy;

import java.util.*;

/*
An integer n is a power of 2 if there exists an integer x such that n == 2^x
Input: n = 16
Output: true
Explanation: 2^4 = 16 where x is 4 and n is 16
 */
public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {

        /* Using loop
        long num = 1;
        while (num < n) {
            num *= 2;
        }
        return num == n;
        */

        // Using bit manipulation
        if(n <= 0) return false;
        int val = (n & (n-1));
        return val == 0;

    }

    /*
    while(1 < 16) num = 2
    while(2 < 16) num = 4
    while(4 < 16) num = 16
    16 is not lesser than 16, return 16

    2^0 ==> 1 ==> 00000001
    2^1 ==> 2 ==> 00000010
    2^2 ==> 4 ==> 00000100
    2^3 ==> 8 ==> 00001000
    2^4 ==> 16 ==> 00010000

    2^4 is same as 1 << 4 which is same as 10000

    n               =  1 0 0 0 0
    n - 1           =  0 1 1 1 1
    n & (n - 1)     =  0 0 0 0 0

    If n is a power of 2, only 1 of its bits will be 1
    n - 1 will hence have only 1 bit as 0 and the remaining as 1
    The bitwise AND operation of n and n - 1 will thus produce all 0s if n is a power of 2.
    */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(isPowerOfTwo(n));
    }
}
