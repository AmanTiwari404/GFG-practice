//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
private:
    bool isSafe(int row, int col, vector<int>& currentPlacement) {
        for (int prevCol = 0; prevCol < col; prevCol++) {
            int prevRow = currentPlacement[prevCol];
            
            if (prevRow == row)
                return false;
                
            if (abs(prevRow - row) == abs(prevCol - col))
                return false;
        }
        return true;
    }
    
    void solveNQueensUtil(int col, int n, vector<int>& currentPlacement,
                         vector<vector<int>>& result) {
        if (col == n) {
            result.push_back(currentPlacement);
            return;
        }
        
        for (int row = 1; row <= n; row++) {
            if (isSafe(row, col, currentPlacement)) {
                currentPlacement[col] = row;
                solveNQueensUtil(col + 1, n, currentPlacement, result);
                currentPlacement[col] = 0;
            }
        }
    }
    
public:
    vector<vector<int>> nQueen(int n) {
        vector<vector<int>> result;
        
        if (n < 1) return result;
        
        vector<int> currentPlacement(n, 0);
        
        solveNQueensUtil(0, n, currentPlacement, result);
        
        return result;
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
        vector<vector<int>> ans = ob.nQueen(n);
        if (ans.size() == 0)
            cout << -1 << "\n";
        else {
            sort(ans.begin(), ans.end());
            for (int i = 0; i < ans.size(); i++) {
                cout << "[";
                for (int u : ans[i])
                    cout << u << " ";
                cout << "] ";
            }
            cout << endl;
        }

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends