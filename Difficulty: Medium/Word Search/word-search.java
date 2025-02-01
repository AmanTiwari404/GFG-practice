//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    static public boolean isWordExist(char[][] mat, String word) {
        if (mat == null || mat.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        
        int n = mat.length;
        int m = mat[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[n][m];
                    if (dfs(mat, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    static private boolean dfs(char[][] mat, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || 
            visited[i][j] || mat[i][j] != word.charAt(index)) {
            return false;
        }
        
        visited[i][j] = true;
        
        for (int d = 0; d < 4; d++) {
            int newI = i + dx[d];
            int newJ = j + dy[d];
            
            if (dfs(mat, word, newI, newJ, index + 1, visited)) {
                return true;
            }
        }
        
        visited[i][j] = false;
        
        return false;
    }
}