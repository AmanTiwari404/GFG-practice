//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPermutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        
        ArrayList<String> result = new ArrayList<>();
        boolean[] used = new boolean[chars.length];
        StringBuilder current = new StringBuilder();
        
        generatePermutations(chars, used, current, result);
        return result;
    }
    
    private void generatePermutations(char[] chars, boolean[] used, 
                                    StringBuilder current, ArrayList<String> result) {
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }
        
        char lastUsed = '\0';
        
        for (int i = 0; i < chars.length; i++) {
            if (used[i] || chars[i] == lastUsed) {
                continue;
            }
            
            used[i] = true;
            current.append(chars[i]);
            
            generatePermutations(chars, used, current, result);
            
            used[i] = false;
            current.setLength(current.length() - 1);
            
            lastUsed = chars[i];
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        System.out.println("Test case 1:");
        ArrayList<String> result1 = solution.findPermutation("ABC");
        System.out.println(result1);
        
        System.out.println("\nTest case 2:");
        ArrayList<String> result2 = solution.findPermutation("AAA");
        System.out.println(result2);
        
        System.out.println("\nTest case 3:");
        ArrayList<String> result3 = solution.findPermutation("ABSG");
        System.out.println(result3);
    }
}