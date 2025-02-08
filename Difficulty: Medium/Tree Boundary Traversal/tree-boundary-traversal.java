//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution T = new Solution();

            ArrayList<Integer> res = T.boundaryTraversal(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) return result;
        
        // Add root
        result.add(node.data);
        if (isLeaf(node)) return result;
        
        // Add left boundary
        addLeftBoundary(node.left, result);
        
        // Add leaf nodes
        addLeaves(node, result);
        
        // Add right boundary in reverse order
        addRightBoundary(node.right, result);
        
        return result;
    }
    
    private boolean isLeaf(Node node) {
        return (node != null && node.left == null && node.right == null);
    }
    
    private void addLeftBoundary(Node node, ArrayList<Integer> result) {
        Node current = node;
        while (current != null) {
            if (!isLeaf(current)) {
                result.add(current.data);
            }
            if (current.left != null) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
    }
    
    private void addLeaves(Node node, ArrayList<Integer> result) {
        if (node == null) return;
        
        if (isLeaf(node)) {
            result.add(node.data);
            return;
        }
        
        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }
    
    private void addRightBoundary(Node node, ArrayList<Integer> result) {
        if (node == null) return;
        
        ArrayList<Integer> temp = new ArrayList<>();
        Node current = node;
        
        while (current != null) {
            if (!isLeaf(current)) {
                temp.add(current.data);
            }
            if (current.right != null) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        
        // Add in reverse order
        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i));
        }
    }
}
