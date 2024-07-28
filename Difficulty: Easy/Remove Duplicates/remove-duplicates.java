//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();

            Solution ob = new Solution();
            String result = ob.removeDups(s);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String removeDups(String str) {
        boolean[] seen = new boolean[26]; 
        StringBuilder result = new StringBuilder();
        
        for (char c : str.toCharArray()) {
    
            if (!seen[c - 'a']) {
                result.append(c);
                seen[c - 'a'] = true;
            }
        }
        
        return result.toString();
    }
}