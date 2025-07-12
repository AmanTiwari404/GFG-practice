class Solution {
    public int splitArray(int[] arr, int k) {
        int left = 0, right = 0;
        for (int num : arr) {
            left = Math.max(left, num);
            right += num;
        }
        int res = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canSplit(arr, k, mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
    private boolean canSplit(int[] arr, int k, int maxSum) {
        int cnt = 1, curr = 0;
        for (int num : arr) {
            if (curr + num > maxSum) {
                cnt++;
                curr = num;
                if (cnt > k) return false;
            } else {
                curr += num;
            }
        }
        return true;
    }
}
