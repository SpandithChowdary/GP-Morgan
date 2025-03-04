package GP_morgan;

import java.util.*;

public class Total_distinct_money_onlyUNIQUE {
	static int R, C;
    static int[][] grid;
    static HashSet<Integer> uniqueSums; 
    static int totalWays = 0;
    static int totalSum = 0;
    
    static void findPaths(int i, int j, int sum) {
        sum += grid[i][j];
        if (i == R - 1 && j == C - 1) {
            if (!uniqueSums.contains(sum)) {
                uniqueSums.add(sum);
                totalWays++; 
                totalSum += sum; 
            }
            return;
        }
        // Move Right
        if (j + 1 < C) {
            findPaths(i, j + 1, sum);
        }
        // Move Down
        if (i + 1 < R) {
            findPaths(i + 1, j, sum);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        grid = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        uniqueSums = new HashSet<>();
        findPaths(0, 0, 0); 
        System.out.println(totalWays);
        System.out.println(totalSum);
        sc.close();
    }
}

/*
Problem Statement:
You woke up from sleep and found yourself in the 0th row and 0th column of a grid. every
other square in a grid has some amount of money kept there. If you are given the matrix with
all the values left in the cells, you have to find how many different ways are there to rich the
r-1 th , c-1 th cell and the sum of all possible amount of money you will have each time if you
bring all the money kept in places in the cell.
Note that, if you are in i,j th cell, either you can go i+1, j th cell or you can go i,j+1 cell.
Again, the 0,0th grid and the n-1,m-1 th grid will have 0 value.
Input Format:
Two integers R and C meaning the number of rows and columns.
Next R lines C space separated integers denoting the total grid.
Output Format:
First Line denoting the distinct ways to rich.
Next line denotes the total money if you use all possible distinct ways (Given that if you take
the money from a cell, the money is readded in the cell).
Sample Input:
3 3
0 2 3
1 3 2
1 1 0
Sample Output:
4
21
Explanation:
The all possible totals are:
0 -> 2 -> 3 -> 2 -> 0 Total = 7
0 -> 2 -> 3 -> 2 -> 0 Total = 7
0 -> 2 -> 3 -> 1 -> 0 Total = 6
0 -> 1 -> 3 -> 2 -> 0 Total = 6
0 -> 1 -> 3 -> 1 -> 0 Total = 5
0 -> 1 -> 1 -> 1 -> 0 Total = 3
There are 4 distinct ways and the total is 21
*/