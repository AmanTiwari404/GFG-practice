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
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) {
            return -1;
        }

        int start = getMax(arr);
        int end = getSum(arr);
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isValid(arr, n, k, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    private static boolean isValid(int[] arr, int n, int k, int maxPages) {
        int studentsRequired = 1;
        int currentSum = 0;

        for (int pages : arr) {
            if (pages > maxPages) return false;

            if (currentSum + pages > maxPages) {
                studentsRequired++;
                currentSum = pages;
                if (studentsRequired > k) return false;
            } else {
                currentSum += pages;
            }
        }

        return true;
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    private static int getSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}