package com.mathsEasy;

import java.util.*;

/*
Input: a = 1010, b = 1011
Output: 10101
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        // use pointers for last digit of both the strings because addition starts from least significant digit
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0; // any addition between 2 digits will either give 1 or a carry
        while(i >= 0 || j >= 0){
            int sum = carry; // add the carry from last addition to sum

            /*
            ASCII Character 0 is ASCII Decimal 48 & ASCII Character 1 is ASCII Decimal 49
            Assiging a character to integer would just assign ASCII decimal value so we have to subtract the same decimal value
            if character is 0, sum should store decimal 0 (not decimal 48)
            if character is 1, sum should store decimal 1 (not decimal 49)
            */
            if(i >= 0){
                sum += a.charAt(i--) - '0';
            }
            if(j >= 0){
                sum += b.charAt(j--) - '0';
            }

            sb.append(sum % 2); // if sum is 0 or 2, we need to set the digit at that index to 0
            carry = sum / 2; // if the sum is 2 or 3, we will have 1 as our carry
        }

        // if a carry is still left out after the end of loop, append it to the string
        // (11 + 1 gives 00 in the loop, we append 1 to get 100 instead which is the solution)
        if(carry != 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    /*
    i = 4
    j = 4
    while(4 >= 0 || 4 >= 0){
    sum = 0, sum+= 0, sum += 1, sb.append(1), carry = 0
    sum = 0, sum+= 1, sum += 1, sb.append(0), carry = 1
    sum = 1, sum += 0, sum += 0, sb.append(1), carry = 0
    sum = 0, sum += 1, sum += 1, sb.append(0), carry = 1
    }
    sb.append(1)
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        String b = scan.nextLine();
        System.out.println(addBinary(a, b));
    }
}
