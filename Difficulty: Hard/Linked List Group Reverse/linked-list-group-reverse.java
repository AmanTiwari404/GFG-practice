//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class ReverseInSize {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {

            String s[] = in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < s.length; i++) {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverseKGroup(head, k);
            printList(res, out);
            out.println();

            out.println("~");
        }
        out.close();
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
    }
}

// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    private static int getLength(Node head) {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
    
    // Helper function to reverse a portion of the linked list
    private static Node reverseSegment(Node head, int k) {
        Node prev = null;
        Node current = head;
        Node next = null;
        int count = 0;
        
        // Reverse k nodes
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        
        // Connect with the rest of the list
        if (next != null) {
            head.next = next;
        }
        
        return prev;
    }
    
    public static Node reverseKGroup(Node head, int k) {
        // Handle base cases
        if (head == null || k == 1) {
            return head;
        }
        
        // Get length of the linked list
        int length = getLength(head);
        
        // If k is greater than length, reverse the whole list
        if (k > length) {
            return reverseSegment(head, length);
        }
        
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        Node current = head;
        Node next = null;
        
        // Process all segments of k nodes
        int remainingNodes = length;
        
        while (remainingNodes >= k) {
            current = prev.next;  // Current group start
            next = current.next;  // Next node
            
            // Reverse current group of k nodes
            for (int i = 1; i < k; i++) {
                current.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = current.next;
            }
            
            prev = current;
            remainingNodes -= k;
        }
        
        // Handle remaining nodes if any
        if (remainingNodes > 0) {
            prev.next = reverseSegment(prev.next, remainingNodes);
        }
        
        return dummy.next;
    }
}
