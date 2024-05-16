//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, n - 1, 2);

            Solution obj = new Solution();
            int res = obj.minimumEdgeRemove(n, edges);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public int minimumEdgeRemove(int n, int[][] edges) {
       // Create adjacency list for the tree
        List<Integer>[] tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            tree[u].add(v);
            tree[v].add(u);
        }
        
        // Array to store the size of each subtree
        int[] subtreeSize = new int[n + 1];
        // To keep track of visited nodes in DFS
        boolean[] visited = new boolean[n + 1];
        
        // Perform DFS from the root node (node 1) to calculate subtree sizes
        dfs(1, tree, subtreeSize, visited);
        
        // Count the number of removable edges
        int removableEdges = 0;
        for (int i = 2; i <= n; i++) { // start from 2 because node 1 is the root
            if (subtreeSize[i] % 2 == 0) {
                removableEdges++;
            }
        }
        
        return removableEdges;
    }
    
    private void dfs(int node, List<Integer>[] tree, int[] subtreeSize, boolean[] visited) {
        visited[node] = true;
        subtreeSize[node] = 1; // Initialize the size of the subtree rooted at 'node' to 1 (itself)
        
        for (int neighbor : tree[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, tree, subtreeSize, visited);
                subtreeSize[node] += subtreeSize[neighbor]; // Add the size of the subtree of the neighbor to the current node's subtree
            }
        }
    }
}
