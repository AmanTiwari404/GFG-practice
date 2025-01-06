//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        List<Integer> result = new ArrayList<>();
        
        if (arr == null || arr.length < 2) {
            return result;
        }
        
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        int minDiff = Integer.MAX_VALUE;
        int finalLeft = -1, finalRight = -1;
        
        
        while (left < right) {
            int sum = arr[left] + arr[right];
            int currentDiff = Math.abs(sum - target);
            
            if (currentDiff < minDiff || 
                (currentDiff == minDiff && (arr[right] - arr[left]) > (arr[finalRight] - arr[finalLeft]))) {
                minDiff = currentDiff;
                finalLeft = left;
                finalRight = right;
            }
            
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                break;
            }
        }
        
        if (finalLeft != -1 && finalRight != -1) {
            result.add(arr[finalLeft]);
            result.add(arr[finalRight]);
        }
        
        return result;
    }
}
