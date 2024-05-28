//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int w;
            w = Integer.parseInt(br.readLine());

            int[] cost = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.minimumCost(n, w, cost);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int minimumCost(int n, int w, int[] cost) {
        int[] dp = new int[w + 1];
        for (int i = 1; i <= w; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        
        for (int j = 1; j <= w; j++) {
            for (int i = 1; i <= n; i++) {
                if (i <= j && cost[i - 1] != -1 && dp[j - i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i] + cost[i - 1]);
                }
            }
        }
        
    
        return dp[w] == Integer.MAX_VALUE ? -1 : dp[w];
    }
}
