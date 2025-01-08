//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countTriangles(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        int n = arr.length, cnt = 0;
        Arrays.sort(arr);
    
        for(int i = n-1; i >= 2; i--) {
            int l = 0, r = i-1;
            while(l < r) {
                if(arr[l] + arr[r] > arr[i]) {
                    cnt += r-l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return cnt;
    }
}