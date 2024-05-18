//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.findClosest(n, k, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findClosest(int n, int k, int[] arr) {
        
        if (k <= arr[0]) {
            return arr[0];
        }
        
        if (k >= arr[n - 1]) {
            return arr[n - 1];
        }

        
        int left = 0, right = n - 1;
        int closest = arr[0];
        
        while (left <= right) {
            int mid = left + (right - left) / 2;

            
            if (Math.abs(arr[mid] - k) < Math.abs(closest - k) || 
                (Math.abs(arr[mid] - k) == Math.abs(closest - k) && arr[mid] > closest)) {
                closest = arr[mid];
            }

            if (arr[mid] == k) {
                return arr[mid]; 
            } else if (arr[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        
        return closest;
    }
}
        
