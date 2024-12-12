//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countFreq(int[] arr, int target) {
        int f = firstOccurrence(arr, target);
        if (f == -1) return 0;
        int l = lastOccurrence(arr, target);
        return l - f + 1;
    }

    private int firstOccurrence(int[] arr, int t) {
        int lo = 0, hi = arr.length - 1, res = -1;
        while (lo <= hi) {
            int m = lo + (hi - lo) / 2;
            if (arr[m] == t) {
                res = m;
                hi = m - 1;
            } else if (arr[m] < t) {
                lo = m + 1;
            } else {
                hi = m - 1;
            }
        }
        return res;
    }

    private int lastOccurrence(int[] arr, int t) {
        int lo = 0, hi = arr.length - 1, res = -1;
        while (lo <= hi) {
            int m = lo + (hi - lo) / 2;
            if (arr[m] == t) {
                res = m;
                lo = m + 1;
            } else if (arr[m] < t) {
                lo = m + 1;
            } else {
                hi = m - 1;
            }
        }
        return res;
    }
}