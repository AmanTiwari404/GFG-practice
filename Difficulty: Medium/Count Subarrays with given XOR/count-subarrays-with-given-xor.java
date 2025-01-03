//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int arr[], int k) {
        Map<Integer, Integer> prefixXor = new HashMap<>();
        
        int currXor = 0;
        long count = 0;
       
        prefixXor.put(0, 1);
        
        for (int num : arr) {
            
            currXor ^= num;
            
            
            count += prefixXor.getOrDefault(currXor ^ k, 0);
            
            
            prefixXor.merge(currXor, 1, Integer::sum);
        }
        
        return count;
    }
}
