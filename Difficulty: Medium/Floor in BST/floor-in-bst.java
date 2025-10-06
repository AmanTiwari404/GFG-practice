// User function Template for Java

class Solution {
    public static int floor(Node root, int x) {
        // Code here
        int floor = -1;
        
        while(root != null){
            if(root.data == x){
                floor = root.data;
                return floor;
            }
            
            if(x < root.data){
                root = root.left;
            }
            else{
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }
}