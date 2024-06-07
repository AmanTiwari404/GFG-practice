//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            // taking size of array
            int n = Integer.parseInt(br.readLine().trim());
            int l[] = new int[n];
            int r[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements to array L
            for (int i = 0; i < n; i++) {
                l[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int maxx = Integer.MIN_VALUE;

            // adding elements to array R
            for (int i = 0; i < n; i++) {
                r[i] = Integer.parseInt(inputLine[i]);
                if (r[i] > maxx) {
                    maxx = r[i];
                }
            }

            Solution obj = new Solution();

            // calling maxOccured() function
            System.out.println(obj.maxOccured(n, l, r, maxx));
        }
    }
}


// } Driver Code Ends
// L[] and R[] are input ranges
// n : size of array
// maxx: maximum element in R[]
// arr[]: declared globally with size equal to 1000000

class Solution {
    // Function to find the maximum occurred integer in all ranges.
    public static int maxOccured(int n, int l[], int r[], int maxx) {
        int[] freq = new int[maxx + 2];
        for (int i = 0; i < n; i++) {
            freq[l[i]]++;
            if (r[i] + 1 <= maxx) {
                freq[r[i] + 1]--;
            }
        }

        int maxFreq = 0;
        int maxOccurInteger = 0;
        int currentFreq = 0;

        for (int i = 0; i <= maxx; i++) {
            currentFreq += freq[i];
            if (currentFreq > maxFreq) {
                maxFreq = currentFreq;
                maxOccurInteger = i;
            }
        }

        return maxOccurInteger;
    }
    
    public static void main(String[] args) {
        int n1 = 4;
        int[] l1 = {1, 4, 3, 1};
        int[] r1 = {15, 8, 5, 4};
        int maxx1 = 15;
        System.out.println(maxOccured(n1, l1, r1, maxx1)); // Output: 4

        int n2 = 5;
        int[] l2 = {1, 5, 9, 13, 21};
        int[] r2 = {15, 8, 12, 20, 30};
        int maxx2 = 30;
        System.out.println(maxOccured(n2, l2, r2, maxx2)); // Output: 5
    }
}

//{ Driver Code Starts.

// } Driver Code Ends