//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {

        // taking input using BufferedReader class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking total count of testcases
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // Reading the two Strings
            String s1 = br.readLine();
            String s2 = br.readLine();

            // Creating an object of class Rotate
            Solution obj = new Solution();

            // calling areRotations method
            // of class Rotate and printing
            //"1" if it returns true
            // else "0"
            if (obj.areRotations(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
// } Driver Code Ends



class Solution {
    public static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int n = s1.length();
        String concatenated = s1 + s1;

        return isSubstringRabinKarp(concatenated, s2, n);
    }

    private static boolean isSubstringRabinKarp(String text, String pattern, int length) {
        int n = text.length();
        int m = pattern.length();
        int prime = 101; 
        int base = 256;  
        int patternHash = 0; 
        int textHash = 0;    
        int h = 1;

        
        for (int i = 0; i < m - 1; i++) {
            h = (h * base) % prime;
        }

        for (int i = 0; i < m; i++) {
            patternHash = (base * patternHash + pattern.charAt(i)) % prime;
            textHash = (base * textHash + text.charAt(i)) % prime;
        }

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash) {
                int j;
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == m) return true; 
            }

            if (i < n - m) {
                textHash = (base * (textHash - text.charAt(i) * h) + text.charAt(i + m)) % prime;
                if (textHash < 0) textHash += prime;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(areRotations("abcd", "cdab")); 
        System.out.println(areRotations("aab", "aba"));   
        System.out.println(areRotations("abcd", "acbd"));
    }
}