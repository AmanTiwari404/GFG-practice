//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int T = Integer.parseInt(br.readLine());

        // Process each test case
        while (T-- > 0) {
            // Read the entire line containing the array elements
            String line = br.readLine();

            // Split the line into an array of strings, then parse them as integers
            String[] tokens = line.split("\\s+");
            int[] a = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                a[i] = Integer.parseInt(tokens[i]);
            }

            // Create the Solution object
            Solution obj = new Solution();

            // Call maxLen function and print the result
            System.out.println(obj.maxLen(a));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxLen(int[] arr) {
        int[] converted = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            converted[i] = arr[i] == 0 ? -1 : 1;
        }
        
        
        int[] cumSum = new int[arr.length];
        cumSum[0] = converted[0];
        for (int i = 1; i < arr.length; i++) {
            cumSum[i] = cumSum[i-1] + converted[i];
        }
        
        
        Map<Integer, Integer> sumIndex = new HashMap<>();
        sumIndex.put(0, -1);  
        int maxLen = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int sum = cumSum[i];
            
            
            if (sum == 0) {
                maxLen = Math.max(maxLen, i + 1);
            }
            
            if (sumIndex.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - sumIndex.get(sum));
            } else {
                sumIndex.put(sum, i);
            }
        }
        
        return maxLen;
    }
}
