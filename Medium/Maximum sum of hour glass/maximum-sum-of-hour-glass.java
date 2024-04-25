//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s[] = read.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int Mat[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    Mat[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.findMaxSum(N, M, Mat));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int findMaxSum(int n, int m, int mat[][]) {
        // Initialize maxSum with the minimum integer value
        int maxSum = Integer.MIN_VALUE;
        
        // Check if the matrix is large enough to contain an hourglass
        if (n < 3 || m < 3) {
            return -1;
        }
        
        // Iterate over the matrix to find the maximum hourglass sum
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                int sum = mat[i][j] + mat[i][j + 1] + mat[i][j + 2]
                        + mat[i + 1][j + 1]
                        + mat[i + 2][j] + mat[i + 2][j + 1] + mat[i + 2][j + 2];
                
                // Update maxSum if current sum is greater
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        
        // Return maxSum or -1 if no hourglass is found
        return maxSum == Integer.MIN_VALUE ? -1 : maxSum;
    }
}