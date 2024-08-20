//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) 
    {
        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = findAndMapParents(root, target, parentMap);
        return burnTree(targetNode, parentMap);
    }

    private static Node findAndMapParents(Node root, int target, Map<Node, Node> parentMap) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node targetNode = null;
        
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            
            if (currentNode.data == target) {
                targetNode = currentNode;
            }
            
            if (currentNode.left != null) {
                parentMap.put(currentNode.left, currentNode);
                queue.offer(currentNode.left);
            }
            
            if (currentNode.right != null) {
                parentMap.put(currentNode.right, currentNode);
                queue.offer(currentNode.right);
            }
        }
        
        return targetNode;
    }

    private static int burnTree(Node targetNode, Map<Node, Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        
        queue.offer(targetNode);
        visited.add(targetNode);
        int time = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burnedAtLeastOneNode = false;
            
            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                
                if (currentNode.left != null && !visited.contains(currentNode.left)) {
                    queue.offer(currentNode.left);
                    visited.add(currentNode.left);
                    burnedAtLeastOneNode = true;
                }
                
                if (currentNode.right != null && !visited.contains(currentNode.right)) {
                    queue.offer(currentNode.right);
                    visited.add(currentNode.right);
                    burnedAtLeastOneNode = true;
                }
                
                if (parentMap.containsKey(currentNode) && !visited.contains(parentMap.get(currentNode))) {
                    queue.offer(parentMap.get(currentNode));
                    visited.add(parentMap.get(currentNode));
                    burnedAtLeastOneNode = true;
                }
            }
            
            if (burnedAtLeastOneNode) {
                time++;
            }
        }
        
        return time;
    }
}