class Solution {
    public String minWindow(String s1, String s2) {
        if(s2.isEmpty()) return "";
        
        int m = s1.length();
        int n = s2.length();
        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;
        
        // Try starting from each position in s1
        for(int i = 0; i < m; i++) {
            if(s1.charAt(i) == s2.charAt(0)) {
                int s1Ptr = i;
                int s2Ptr = 0;
                
                // Match characters of s2 in s1
                while(s1Ptr < m && s2Ptr < n) {
                    if(s1.charAt(s1Ptr) == s2.charAt(s2Ptr)) {
                        s2Ptr++;
                    }
                    s1Ptr++;
                }
                
                // If all characters of s2 were found
                if(s2Ptr == n) {
                    int len = s1Ptr - i;
                    if(len < minLen) {
                        minLen = len;
                        startIdx = i;
                    }
                }
            }
        }
        
        if(startIdx == -1) return "";
        return s1.substring(startIdx, startIdx + minLen);
    }
}