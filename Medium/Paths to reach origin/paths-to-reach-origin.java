//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    public static int ways(int n, int m)
    {
        // Initialize a 2D array to store the number of paths
        int[][] dp = new int[n + 1][m + 1];
        
        // Base case: There is only one way to reach any point on the first row or column
        for (int i = 0; i <= n; i++)
        {
            dp[i][0] = 1;
        }
        
        for (int j = 0; j <= m; j++)
        {
            dp[0][j] = 1;
        }
        
        // Calculate the number of paths for each point using the recurrence relation
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
            }
        }
        
        // Return the number of paths to reach (n, m)
        return dp[n][m] % 1000000007;
    }
}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    int x=Integer.parseInt(elements[0]);
		    int y=Integer.parseInt(elements[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.ways(x,y));
		}
	}
}
// } Driver Code Ends