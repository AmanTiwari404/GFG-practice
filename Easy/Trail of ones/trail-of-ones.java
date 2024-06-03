//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfConsecutiveOnes(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int MOD = (int)1e9 + 7;
    
    static int numberOfConsecutiveOnes(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        
        long[] dp = new long[n + 1];
        
        dp[1] = 2; 
        dp[2] = 3; 
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        
        long total = 1;
        for (int i = 0; i < n; i++) {
            total = (total * 2) % MOD;
        }
        
        long result = (total - dp[n] + MOD) % MOD;
        return (int) result;
    }
}
