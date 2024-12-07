//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int inversionCount(int arr[]) {
        int[] temp = new int[arr.length];
        return count(arr, temp, 0, arr.length - 1);
    }

    private static int count(int[] arr, int[] temp, int l, int r) {
        int m, c = 0;
        if (l < r) {
            m = (l + r) / 2;
            c += count(arr, temp, l, m);
            c += count(arr, temp, m + 1, r);
            c += merge(arr, temp, l, m, r);
        }
        return c;
    }

    private static int merge(int[] arr, int[] temp, int l, int m, int r) {
        int i = l, j = m + 1, k = l, c = 0;
        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                c += (m + 1 - i);
            }
        }
        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];
        for (i = l; i <= r; i++) arr[i] = temp[i];
        return c;
    }
}
