//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int isCircle(String arr[]) {
        int[] inDeg = new int[26], outDeg = new int[26];
        Map<Character, List<Character>> adj = new HashMap<>();

        for (String s : arr) {
            char start = s.charAt(0), end = s.charAt(s.length() - 1);
            outDeg[start - 'a']++;
            inDeg[end - 'a']++;
            adj.computeIfAbsent(start, k -> new ArrayList<>()).add(end);
        }

        for (int i = 0; i < 26; i++) {
            if (inDeg[i] != outDeg[i]) return 0;
        }

        return isConnected(arr, adj) ? 1 : 0;
    }

    private boolean isConnected(String[] arr, Map<Character, List<Character>> adj) {
        Set<Character> vis = new HashSet<>();
        dfs(arr[0].charAt(0), adj, vis);

        for (String s : arr) {
            if (!vis.contains(s.charAt(0)) || !vis.contains(s.charAt(s.length() - 1))) return false;
        }

        return true;
    }

    private void dfs(char c, Map<Character, List<Character>> adj, Set<Character> vis) {
        vis.add(c);
        if (adj.containsKey(c)) {
            for (char next : adj.get(c)) {
                if (!vis.contains(next)) dfs(next, adj, vis);
            }
        }
    }
}
