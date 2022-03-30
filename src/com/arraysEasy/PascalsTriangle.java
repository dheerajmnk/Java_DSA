package com.arraysEasy;

import java.util.*;

/*
Each number is the sum of the 2 numbers directly above it
Input: 5
Output:
[[1],
[1,1],
[1,2,1],
[1,3,3,1],
[1,4,6,4,1]]
*/

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < numRows; i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    row.add(1);
                }
                else{
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }

/*
    i = 0
        j = 0
            row.add(1)

    i = 1
        j = 0
            row.add(1)
        j = 1
            row.add(1)

    i = 2
        j = 0
            row.add(1)
        j = 1
            row.add(1 + 1)
        j = 2
            row.add(1)

    i = 3
        j = 0
            row.add(1)
        j = 1
            row.add(1 + 2)
        j = 2
            row.add(2 + 1)
        j = 3
            row.add(1)

    i = 4
        j = 0
            row.add(1)
        j = 1
            row.add(1 + 3)
        j = 2
            row.add(3 + 3)
        j = 3
            row.add(3 + 1)
        j = 4
            row.add(1)
*/

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numRows = scan.nextInt();
        System.out.println(generate(numRows));
    }
}
