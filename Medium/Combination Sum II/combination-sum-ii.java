//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
            for (List<Integer> list : ans) {
                for (int x : list) ot.print(x + " ");
                ot.println();
            }
            if (ans.size() == 0) ot.println();
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
       List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr); // Sort the array to ensure combinations are in non-decreasing order
        backtrack(arr, 0, k, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] arr, int start, int target, List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) { // If target sum is reached, add the combination to the result
            result.add(new ArrayList<>(combination));
            return;
        }
        if (target < 0 || start == arr.length) return; // Stop if target becomes negative or if reached end of array
        
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) continue; // Skip duplicates to avoid duplicate combinations
            combination.add(arr[i]); // Add current element to the combination
            backtrack(arr, i + 1, target - arr[i], combination, result); // Recur with updated target and start index
            combination.remove(combination.size() - 1); // Backtrack by removing the last element
        }
    }
}