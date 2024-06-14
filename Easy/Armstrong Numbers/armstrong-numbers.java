//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static String armstrongNumber(int n) {
        int d1 = n / 100;   
        int d2 = (n / 10) % 10; 
        int d3 = n % 10;        
        
        int sumOfCubes = (d1 * d1 * d1) + (d2 * d2 * d2) + (d3 * d3 * d3);
        
        if (sumOfCubes == n) {
            return "true";
        } else {
            return "false";
        }
    }
}