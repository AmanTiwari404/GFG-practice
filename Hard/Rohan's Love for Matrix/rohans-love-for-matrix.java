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
            System.out.println(ob.firstElement(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static final int MOD = 1000000007;
    static int firstElement(int n) {
        int[][] A = {{1, 1}, {1, 0}};
        int[][] result = {{1, 0}, {0, 1}};  // Identity matrix

        while (n > 0) {
            if (n % 2 == 1) {
                result = multiplyMatrix(result, A);
            }
            A = multiplyMatrix(A, A);
            n /= 2;
        }

        return result[1][0];  // a10 element
    }

    static int[][] multiplyMatrix(int[][] A, int[][] B) {
        int[][] C = new int[2][2];
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                long sum = 0;
                for (int k = 0; k < 2; k++) {
                    sum += (long) A[i][k] * B[k][j];
                    sum %= MOD;
                }
                C[i][j] = (int) sum;
            }
        }
        
        return C;
    }
}