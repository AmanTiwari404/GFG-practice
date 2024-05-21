//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                left = mid;
                break;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        
        int leftPointer = left - 1;
        int rightPointer = left;
        int[] result = new int[k];
        int idx = 0;
        
        
        while (idx < k) {
            if (leftPointer >= 0 && rightPointer < n) {
                int leftDiff = Math.abs(arr[leftPointer] - x);
                int rightDiff = Math.abs(arr[rightPointer] - x);
                if (leftDiff < rightDiff || (leftDiff == rightDiff && arr[leftPointer] > arr[rightPointer])) {
                    result[idx++] = arr[leftPointer--];
                } else if (arr[rightPointer] != x) { 
                    result[idx++] = arr[rightPointer++];
                } else {
                    rightPointer++;
                }
            } else if (leftPointer >= 0) {
                result[idx++] = arr[leftPointer--];
            } else if (rightPointer < n && arr[rightPointer] != x) {
                result[idx++] = arr[rightPointer++];
            } else {
                rightPointer++;
            }
        }
        
        return result;
    }
}
