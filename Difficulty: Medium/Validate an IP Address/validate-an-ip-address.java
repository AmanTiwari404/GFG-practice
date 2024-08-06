//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String str) {
        String[] parts = str.split("\\.");
        
        if (parts.length != 4) {
            return false;
        }
        
        for (String part : parts) {
            if (!isValidPart(part)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isValidPart(String part) {
        if (part.length() == 0) {
            return false;
        }
        
        if (part.length() > 1 && part.charAt(0) == '0') {
            return false;
        }
        
        try {
            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        
        return true;
    }
}