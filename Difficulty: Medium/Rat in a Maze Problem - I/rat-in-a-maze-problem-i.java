//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    private static final int[] rowDirs = {1, 0, 0, -1};
    private static final int[] colDirs = {0, -1, 1, 0};
    private static final char[] dirSymbols = {'D', 'L', 'R', 'U'};
    
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> result = new ArrayList<>();
        if (mat == null || mat.length == 0 || mat[0].length == 0 || mat[0][0] == 0 || mat[mat.length - 1][mat[0].length - 1] == 0) {
            return result;
        }
        
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        dfs(mat, 0, 0, visited, "", result);
        
        return result.size() > 0 ? result : new ArrayList<>(List.of("-1"));
    }
    
    private void dfs(int[][] mat, int row, int col, boolean[][] visited, String path, ArrayList<String> result) {
        int n = mat.length;
        if (row == n - 1 && col == n - 1) {
            result.add(path);
            return;
        }
        
        visited[row][col] = true;
        
        for (int i = 0; i < 4; i++) {
            int newRow = row + rowDirs[i];
            int newCol = col + colDirs[i];
            
            if (isSafe(mat, newRow, newCol, visited)) {
                dfs(mat, newRow, newCol, visited, path + dirSymbols[i], result);
            }
        }
        
        visited[row][col] = false;
    }
    
    private boolean isSafe(int[][] mat, int row, int col, boolean[][] visited) {
        return row >= 0 && col >= 0 && row < mat.length && col < mat[0].length && mat[row][col] == 1 && !visited[row][col];
    }
}