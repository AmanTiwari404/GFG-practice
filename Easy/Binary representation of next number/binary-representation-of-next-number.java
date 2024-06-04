//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.binaryNextNumber(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
  public String binaryNextNumber(String s) {
    StringBuilder result = new StringBuilder();
    int carry = 1;
    
    
    for (int i = s.length() - 1; i >= 0; i--) {
      int sum = carry + Character.getNumericValue(s.charAt(i));
      carry = sum / 2;
      result.insert(0, sum % 2); 
    }
    
    
    if (carry == 1) {
      result.insert(0, 1);
    }
    
    
    int index = 0;
    while (index < result.length() && result.charAt(index) == '0') {
      index++;
    }
    return result.substring(index);
  }
}
