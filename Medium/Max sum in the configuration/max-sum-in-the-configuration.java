//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            System.out.println(new Solution().max_sum(arr, n));

            t--;
        }
    }
}

// } Driver Code Ends


class Solution {
    long max_sum(int a[], int n) {
        long sum_a = 0;
        for (int i = 0; i < n; i++) {
            sum_a += a[i];
        }

        long curr_val = 0;
        for (int i = 0; i < n; i++) {
            curr_val += (long) i * a[i];
        }

        long max_val = curr_val;

        for (int i = 1; i < n; i++) {
            curr_val = curr_val + sum_a - (long) n * a[n - i];
            if (curr_val > max_val) {
                max_val = curr_val;
            }
        }

        return max_val;
    }
}
