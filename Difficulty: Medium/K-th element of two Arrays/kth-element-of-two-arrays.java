//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] a = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                a[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] b = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                b[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(a, b, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int kthElement(int a[], int b[], int k) {
        if (a.length > b.length) {
            return kthElement(b, a, k);
        }

        int n = a.length;
        int m = b.length;

        int low = Math.max(0, k - m); 
        int high = Math.min(k, n);   

        while (low <= high) {
            int midA = low + (high - low) / 2; 
            int midB = k - midA;              

            
            int leftA = (midA > 0) ? a[midA - 1] : Integer.MIN_VALUE;
            int leftB = (midB > 0) ? b[midB - 1] : Integer.MIN_VALUE;

            int rightA = (midA < n) ? a[midA] : Integer.MAX_VALUE;
            int rightB = (midB < m) ? b[midB] : Integer.MAX_VALUE;

            
            if (leftA <= rightB && leftB <= rightA) {
                return Math.max(leftA, leftB);
            } else if (leftA > rightB) {
                high = midA - 1; 
            } else {
                low = midA + 1; 
            }
        }

        throw new IllegalArgumentException("Invalid input"); 
    }
}