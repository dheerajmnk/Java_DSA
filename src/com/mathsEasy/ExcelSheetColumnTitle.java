package com.mathsEasy;

import java.util.*;

/*
Given column number, return corresponding excel sheet column title
Input: 1
Output: A
Input: 28
Output: AB
 */
public class ExcelSheetColumnTitle {

    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0){
            columnNumber--;
            char rightMost = (char) (columnNumber % 26 + 'A');
            sb.append(rightMost);
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    /*
    while(28 > 0){
    28--;
    char rightmost = 27 % 26 + 'A' = 1 + 'A' = B
    columnNumber = 1
    }
    while(1 > 0){
    1--;
    char rightmost = 0 % 26 + 'A' = 0 + 'A' = A
    columnNumber = 0
    }
    */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(convertToTitle(n));
    }
}
