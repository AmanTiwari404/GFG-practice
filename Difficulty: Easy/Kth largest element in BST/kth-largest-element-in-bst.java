/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution {
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root, int k) {
        // Your code here
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root , arr);
        int kLargest = arr.get(arr.size()- k);
        return kLargest;
    }
    
    public void inorder(Node root, List arr){
        if(root == null) return;
        
        inorder(root.left , arr);
        arr.add(root.data);
        inorder(root.right , arr);
        return;
    }
}