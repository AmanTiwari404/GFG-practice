//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        if (arr == null || arr.length == 0) {
            return "-1";
        }
        
        int minLen = arr[0].length();
        for (String str : arr) {
            minLen = Math.min(minLen, str.length());
        }
        
        int low = 1;
        int high = minLen;
        
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(arr, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        
        String commonPrefix = arr[0].substring(0, (low + high) / 2);
        return commonPrefix.isEmpty() ? "-1" : commonPrefix;
    }
    
    private boolean isCommonPrefix(String[] arr, int len) {
        String prefix = arr[0].substring(0, len);
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}