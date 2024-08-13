//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    long floorSqrt(long n) {
        if (n == 0 || n == 1) return n;

        long start = 1, end = n, ans = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long midSq = mid * mid;

            if (midSq == n) return mid;  
            if (midSq < n) {
                start = mid + 1;
                ans = mid;  
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
