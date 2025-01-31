//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = 9;
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.solveSudoku(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static void solveSudoku(int[][] mat) {
        solve(mat);
    }
    
    private static boolean solve(int[][] mat) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (mat[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(mat, row, col, num)) {
                            mat[row][col] = num;
                            
                            if (solve(mat)) {
                                return true;
                            }
                            
                            mat[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean isSafe(int[][] mat, int row, int col, int num) {
        for (int x = 0; x < 9; x++) {
            if (mat[row][x] == num) {
                return false;
            }
        }
        
        for (int x = 0; x < 9; x++) {
            if (mat[x][col] == num) {
                return false;
            }
        }
        
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mat[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }
        
        return true;
    }
}