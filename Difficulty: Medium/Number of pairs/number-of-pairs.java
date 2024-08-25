//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int x[] = new int[str.length];
            for (int i = 0; i < str.length; i++) x[i] = Integer.parseInt(str[i]);
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                y[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countPairs(x, y, x.length, y.length));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
    public long countPairs(int x[], int y[], int M, int N) {
        Arrays.sort(y);
        long count = 0;
        long[] freq = new long[5];
        for (int i = 0; i < N; i++) {
            if (y[i] < 5) {
                freq[y[i]]++;
            }
        }

        for (int a : x) {
            if (a == 0) continue;
            if (a == 1) {
                continue;
            }

            int idx = binarySearch(y, a);
            count += (N - idx);

            count += freq[0] + freq[1];

            if (a == 2) {
                count -= (freq[3] + freq[4]);
            }
            if (a == 3) {
                count += freq[2];
            }
        }

        return count;
    }

    int binarySearch(int[] y, int x) {
        int l = 0, r = y.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (y[mid] > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}



