//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(n, m, matrix);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        int[] exitPoint = new int[2];
        int row = 0, col = 0;
        int direction = 0; // 0 for right, 1 for down, 2 for left, 3 for up
        
        while (row >= 0 && row < n && col >= 0 && col < m) {
            if (matrix[row][col] == 1) {
                // Change direction to the right
                direction = (direction + 1) % 4;
                // Change the current cell to 0
                matrix[row][col] = 0;
            }
            // Move according to the current direction
            switch (direction) {
                case 0: // right
                    col++;
                    break;
                case 1: // down
                    row++;
                    break;
                case 2: // left
                    col--;
                    break;
                case 3: // up
                    row--;
                    break;
            }
        }
        
        // When exiting the matrix, the previous cell is the exit point
        exitPoint[0] = row >= n ? n - 1 : row < 0 ? 0 : row;
        exitPoint[1] = col >= m ? m - 1 : col < 0 ? 0 : col;
        
        return exitPoint;
    }
}