//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        if (s == null || s.length() == 0) return 0;
        
        
        int[] charFreq = new int[26];
        
        int maxLength = 0;    
        int start = 0;       
        int windowLen = 0;    
        
        
        for (int end = 0; end < s.length(); end++) {
            
            char currChar = s.charAt(end);
        
            charFreq[currChar - 'a']++;
            windowLen++;
           
            while (charFreq[currChar - 'a'] > 1) {
                char startChar = s.charAt(start);
                charFreq[startChar - 'a']--;
                start++;
                windowLen--;
            }
            
            maxLength = Math.max(maxLength, windowLen);
        }
        
        return maxLength;
    }
}