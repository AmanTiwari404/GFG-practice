//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countPartitions(int n, int d, int[] arr) {
       int MOD = 1000000007;
        int sumArr = 0;
        for (int num : arr) {
            sumArr += num;
        }
        
        if ((sumArr + d) % 2 != 0 || sumArr < d) {
            return 0;
        }
        
        int targetSum = (sumArr + d) / 2;
        
        
        int[] dp = new int[targetSum + 1];
        dp[0] = 1; 
        
        
        for (int num : arr) {
            for (int j = targetSum; j >= num; j--) {
                dp[j] = (dp[j] + dp[j - num]) % MOD;
            }
        }
        
        return dp[targetSum];
    }
}
        
