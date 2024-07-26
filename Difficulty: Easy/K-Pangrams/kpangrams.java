//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    boolean kPangram(String str, int k) {
        int[] arr = new int[26];
        int n = str.length();
        int ch = 0;
        
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) != ' ') {
                arr[str.charAt(i) - 'a'] = 1;
                ch++;
            }
        }
        
        int c = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) {
                c++;
            }
        }
        
        if (ch < 26 || c > k) {
            return false;
        }
        
        return true;
    }
}