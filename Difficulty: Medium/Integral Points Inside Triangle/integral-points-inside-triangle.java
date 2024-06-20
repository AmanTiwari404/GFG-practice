//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            long p[] = new long[2];
            long q[] = new long[2];
            long r[] = new long[2];
            p[0] = Long.parseLong(S[0]);
            p[1] = Long.parseLong(S[1]);
            q[0] = Long.parseLong(S[2]);
            q[1] = Long.parseLong(S[3]);
            r[0] = Long.parseLong(S[4]);
            r[1] = Long.parseLong(S[5]);
            Solution ob = new Solution();
            long ans = ob.InternalCount(p, q, r);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long InternalCount(long p[], long q[], long r[]) {
    long area = (Math.abs(p[0] * (q[1] - r[1]) + q[0] * (r[1] - p[1]) + r[0] * (p[1] - q[1]))) / 2;
    
        long b1 = gcd(Math.abs(p[0] - q[0]), Math.abs(p[1] - q[1]));
        long b2 = gcd(Math.abs(q[0] - r[0]), Math.abs(q[1] - r[1]));
        long b3 = gcd(Math.abs(r[0] - p[0]), Math.abs(r[1] - p[1]));
        
        long boundaryPoints = b1 + b2 + b3;
        
        long internalPoints = area - boundaryPoints / 2 + 1;
        
        return internalPoints;
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

    