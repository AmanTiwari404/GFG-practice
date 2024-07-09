//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().threeSumClosest(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int threeSumClosest(int[] array, int target) {
        Arrays.sort(array);
        int n = array.length;
        int closestSum = array[0] + array[1] + array[2];
    
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
        
            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];
                
                if (currentSum == target) {
                    return currentSum;
                }
                
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target) ||
                    (Math.abs(currentSum - target) == Math.abs(closestSum - target) && currentSum > closestSum)) {
                    closestSum = currentSum;
                }
                
                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return closestSum;
    }
}
