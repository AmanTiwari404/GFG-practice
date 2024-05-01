//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    Node head = null, tail = null;
		    
		    char head_c = sc.next().charAt(0);
		    head = new Node(head_c);
		    tail = head;
		    
		    while(n-- > 1){
		        tail.next = new Node(sc.next().charAt(0));
		        tail = tail.next;
		    }
		    
		    Solution obj = new Solution();
		    //show(head);
		    show(obj.arrangeCV(head));
		    
		}
	}
	
	public static void po(Object o){
	    System.out.println(o);
	}
	
	public static void show(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*
Structure of node class is:
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    
    public Node arrangeCV(Node head){
        Queue<Character> vowel = new LinkedList<>();
        Queue<Character> consonant = new LinkedList<>();

        Node curr = head;
        while (curr != null) {
            if (curr.data == 'a' || curr.data == 'e' || curr.data == 'i' || curr.data == 'o' || curr.data == 'u') {
                vowel.add(curr.data);
            } else {
                consonant.add(curr.data);
            }
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            if (!vowel.isEmpty()) {
                curr.data = vowel.poll();
            } else {
                curr.data = consonant.poll();
            }
            curr = curr.next;
        }

        return head;
    }
}