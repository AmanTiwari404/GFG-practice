//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long getCount(int n) {
        if (n == 1) return 10;  
        
        int[][] adj = {
            {0, 8},        
            {1, 2, 4},     
            {2, 1, 3, 5}, 
            {3, 2, 6},     
            {4, 1, 5, 7},  
            {5, 2, 4, 6, 8},
            {6, 3, 5, 9},  
            {7, 4, 8},     
            {8, 5, 7, 9, 0},
            {9, 6, 8}      
        };
        
        
        long[][] dp = new long[n + 1][10];
        
        for (int digit = 0; digit < 10; digit++) {
            dp[1][digit] = 1;
        }
        
        for (int length = 2; length <= n; length++) {
            for (int digit = 0; digit < 10; digit++) {
                dp[length][digit] = 0;
                for (int neighbor : adj[digit]) {
                    dp[length][digit] += dp[length - 1][neighbor];
                }
            }
        }
        
        long result = 0;
        for (int digit = 0; digit < 10; digit++) {
            result += dp[n][digit];
        }
        
        return result;
    }
}