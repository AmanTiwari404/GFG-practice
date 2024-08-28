//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        
        entryList.sort((e1, e2) -> {
            int freqComparison = e2.getValue().compareTo(e1.getValue());
            if (freqComparison != 0) {
                return freqComparison;
            }
            return e1.getKey().compareTo(e2.getKey());
        });
        
        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : entryList) {
            int number = entry.getKey();
            int frequency = entry.getValue();
            for (int i = 0; i < frequency; i++) {
                result.add(number);
            }
        }
        
        return result;
    }
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends