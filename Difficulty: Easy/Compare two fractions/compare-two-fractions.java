//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        String[] fractions = str.split(", ");
        
        String[] frac1 = fractions[0].split("/");
        int a = Integer.parseInt(frac1[0]);
        int b = Integer.parseInt(frac1[1]);
        
        String[] frac2 = fractions[1].split("/");
        int c = Integer.parseInt(frac2[0]);
        int d = Integer.parseInt(frac2[1]);
        
        if (a * d > b * c) {
            return fractions[0]; 
        } else if (a * d < b * c) {
            return fractions[1]; 
        } else {
            return "equal"; 
        }
    }
}
