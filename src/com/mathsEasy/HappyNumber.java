package com.mathsEasy;

import java.util.*;

/*
Replace given number by sum of squares of its digits
Repeat until number equals 1  or loops endlessly in a cycle
If number ends in 1 it is a happy number
Input: n = 19
Output: true
1^2 + 9^2 = 1 + 81 = 82
8^2 + 2^2 = 64 + 4 = 68
6^2 + 8^2 = 36 + 64 = 100
1^2 + 0^2 + 0^2 = 100
 */
public class HappyNumber {
    public static int getNext(int n) {
        int sum = 0;
        while(n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)){
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    /*
    set.add(19), n = 82
    set.add(82), n = 68
    set.add(68), n = 100
    set.add(100), n = 1
    break out of while loop and return true (n became 1)

    set.add(2), n = 4
    set.add(4), n = 16
    set.add(16), n = 37
    set.add(37), n = 58
    set.add(58), n = 89
    set.add(89), n = 145
    set.add(145), n = 42
    set.add(42), n = 20
    set.add(20), n = 4
    break out of while loop and return false (set contains 4 already which indicates an endless cycle)
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(isHappy(n));
    }
}
