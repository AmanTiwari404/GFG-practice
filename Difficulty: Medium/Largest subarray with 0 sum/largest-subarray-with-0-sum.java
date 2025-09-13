

class Solution {
    int maxLength(int arr[]) {    
        int n = arr.length;      
        HashMap<Integer, Integer> map = new HashMap<>();      //optimized code (hashing)
        int sum = 0;
        int maxLen = 0;
        
        for(int i = 0; i < n; i++){
            sum += arr[i];
            
            
            if(sum == 0){
                maxLen = Math.max(maxLen, i + 1);
            }
            
            
            if(map.containsKey(sum)){
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                
                map.put(sum, i);
            }
        }
        
        return maxLen;
    }
}

// class Solution {
//     int maxLength(int arr[]) {
//         int n = arr.length;         //brute force (nested loop)
//         int maxInd = 0;
//         for(int i = 0; i < n; i++){
//             int sum = arr[i];
//             if(sum == 0) {
//                 maxInd = Math.max(maxInd, 1); 
//             }
//             for(int j = i+1; j < n; j++){
//                 sum += arr[j];
//                 if(sum == 0){
//                     int maxx = j-i+1;
//                     maxInd = Math.max(maxx, maxInd);
//                 }
//             }
//         }
//         return maxInd;
//     }
// }