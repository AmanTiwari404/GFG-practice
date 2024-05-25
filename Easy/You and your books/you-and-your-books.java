//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T > 0) {
            int N = sc.nextInt();
            int k = sc.nextInt();
            int ar[] = new int[N];
            //	int count = 0;
            for (int i = 0; i < N; i++) ar[i] = sc.nextInt();

            System.out.println(new Solution().max_Books(ar, N, k));
            T--;
        }
    }
}
// } Driver Code Ends



class Solution {
    long max_Books(int arr[], int n, int k) {
        long max_books = 0;
        long current_sum = 0;
        int start = 0;
        
        for (int end = 0; end < n; end++) {
            if (arr[end] <= k) {
                current_sum += arr[end];
            } else {
                current_sum = 0;
                start = end + 1;
            }
            max_books = Math.max(max_books, current_sum);
        }
        
        return max_books;
    }
}