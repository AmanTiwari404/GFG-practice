//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countTriplets(int[] arr, int target) {
        int n = arr.length;
        int count = 0;
        
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                
                if (sum == target) {
                    if (arr[left] == arr[right]) {
                        int range = right - left + 1;
                        count += (range * (range - 1)) / 2;
                        break;
                    }
                    
                    int leftCount = 1;
                    int rightCount = 1;
                    
                    while (left + 1 < right && arr[left] == arr[left + 1]) {
                        leftCount++;
                        left++;
                    }
                    
                    while (right - 1 > left && arr[right] == arr[right - 1]) {
                        rightCount++;
                        right--;
                    }
                    
                    count += leftCount * rightCount;
                    left++;
                    right--;
                }
                else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return count;
    }
}