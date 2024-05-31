//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String oddEven(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        int x = 0; 
        int y = 0; 
        
        
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            char c = entry.getKey();
            int freq = entry.getValue();
            
            
            int position = c - 'a' + 1;
            
            if (position % 2 == 0) { // Even position
                if (freq % 2 == 0) {
                    x++;
                }
            } else { // Odd position
                if (freq % 2 == 1) {
                    y++;
                }
            }
        }
        
        
        if ((x + y) % 2 == 0) {
            return "EVEN";
        } else {
            return "ODD";
        }
    }
}
