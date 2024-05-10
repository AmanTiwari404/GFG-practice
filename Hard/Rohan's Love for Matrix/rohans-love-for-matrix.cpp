//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++
class Solution {
  public:

    int firstElement(int n) 
    {
        // code here
        const int M = 1000000007;
        int n1 = 0,n2=1,n3;
        int c=0;
        while(c!=n-1){
            n3 = (n1+n2)%M;
            n1 = n2%M;
            n2 = n3%M;
            c++;
        }
        return n2;
        
    }
};



//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Solution ob;
        cout << ob.firstElement(n) << endl;
    }
    return 0;
}

// } Driver Code Ends