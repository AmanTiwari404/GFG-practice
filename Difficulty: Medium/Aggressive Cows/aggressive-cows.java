//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        
        int low = 1; 
        int high = stalls[stalls.length - 1] - stalls[0]; 
        int result = 0;
        
    
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isFeasible(stalls, k, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1; 
            }
        }
        
        return result;
    }

    private static boolean isFeasible(int[] stalls, int k, int minDist) {
        int countCows = 1; 
        int lastPosition = stalls[0];
        
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= minDist) {
                countCows++;
                lastPosition = stalls[i];
            }
            
            if (countCows >= k) return true;
        }
        
        return false;
    }
}