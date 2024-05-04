//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Create a hashmap to store the indices of elements in the inorder traversal.
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(in[i], i);
        }
        
        // Call helper function to build tree recursively.
        return buildTreeHelper(in, post, 0, n - 1, 0, n - 1, indexMap);
    }
    
    // Helper function to build tree recursively.
    Node buildTreeHelper(int in[], int post[], int inStart, int inEnd, int postStart, int postEnd, HashMap<Integer, Integer> indexMap) {
        // Base case: If either inorder start is greater than inorder end or postorder start is greater than postorder end, return null.
        if (inStart > inEnd || postStart > postEnd)
            return null;

        // The last element in the postorder traversal is the root of the current subtree.
        int rootValue = post[postEnd];
        Node root = new Node(rootValue);

        // Find the index of rootValue in inorder traversal using the hashmap.
        int rootIndex = indexMap.get(rootValue);

        // Build left and right subtrees recursively.
        root.left = buildTreeHelper(in, post, inStart, rootIndex - 1, postStart, postStart + rootIndex - inStart - 1, indexMap);
        root.right = buildTreeHelper(in, post, rootIndex + 1, inEnd, postStart + rootIndex - inStart, postEnd - 1, indexMap);

        return root;
    }
}
