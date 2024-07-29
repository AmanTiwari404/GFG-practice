//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        int max1sRowIndex = -1;
        int max1sCount = 0;
        int rows = arr.length;
        int cols = arr[0].length;
        
        int r = 0, c = cols - 1;
        
        while (r < rows && c >= 0) {
            if (arr[r][c] == 1) {
                c--;
                max1sRowIndex = r;
            } else {
                r++;
            }
        }
        
        return max1sRowIndex;
    }
}
