//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    for(int i=0;i<t;i++){
	        int n = Integer.parseInt(br.readLine());
	        String l = br.readLine();
    		String[] sarr = l.split(" ");
    		int[] arr = new int[sarr.length];
    		for(int i1=0;i1<arr.length;i1++){
    			arr[i1] = Integer.parseInt(sarr[i1]);
    		}
    		
            Solution obj = new Solution();
            
            int[] res = obj.twoRepeated(arr, n);
            System.out.println(res[0] + " " + res[1]);
	    }
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find two repeated elements.
    public int[] twoRepeated(int arr[], int n)
    {
        int[] result = new int[2];
        
        for (int i = 0; i < n + 2; i++) {
            int index = Math.abs(arr[i]) - 1;
            
            // Check if the element at index is positive. If yes, make it negative.
            if (arr[index] > 0) {
                arr[index] = -arr[index];
            } else {
                // If it's negative, it means we've seen this number before.
                // Add it to the result array.
                if (result[0] == 0) {
                    result[0] = Math.abs(arr[i]);
                } else {
                    result[1] = Math.abs(arr[i]);
                    break;  // Found both repeating numbers, exit the loop
                }
            }
        }
        
        return result;
    }
}
