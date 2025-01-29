//{ Driver Code Starts
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            double b = sc.nextDouble();
            int e = sc.nextInt();
            Solution ob = new Solution();
            System.out.printf("%.5f\n", ob.power(b, e));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends

// User function Template for Java
class Solution {
    double power(double b, int e) {
        if (e == 0) return 1;
        
        double result = 1;
        long exp = Math.abs((long) e);
        
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result *= b;
            }
            b *= b;
            exp >>= 1;
        }
        
        return e < 0 ? 1 / result : result;
    }
}


//{ Driver Code Starts.
// } Driver Code Ends