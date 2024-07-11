//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int dfs(int[][] grid, int i, int j, int index) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = index;
        int count = 0;
        for (int d = 0; d < 4; d++) {
            count += dfs(grid, i + dx[d], j + dy[d], index);
        }
        return count + 1;
    }

    public void neighbours(int[][] grid, int i, int j, Set<Integer> s) {
        int n = grid.length;
        if (i > 0) {
            s.add(grid[i - 1][j]);
        }
        if (j > 0) {
            s.add(grid[i][j - 1]);
        }
        if (i < n - 1) {
            s.add(grid[i + 1][j]);
        }
        if (j < n - 1) {
            s.add(grid[i][j + 1]);
        }
    }

    public int MaxConnection(int[][] grid) {
        int n = grid.length;
        int res = 0;
        int index = 2;
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    mp.put(index, dfs(grid, i, j, index));
                    res = Math.max(res, mp.get(index));
                    index++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> s = new HashSet<>();
                    neighbours(grid, i, j, s);
                    int count = 1;
                    for (int idx : s) {
                        if (idx > 1) {
                            count += mp.getOrDefault(idx, 0);
                        }
                    }
                    res = Math.max(res, count);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{1, 1}, {0, 1}};
        System.out.println(solution.MaxConnection(grid)); 
    }
}
