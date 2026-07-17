class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        
        int right = n - 1;   // pointer scanning from the right
        int maxSoFar = -1;   // greatest element seen so far (to the right)
        
        for (int left = n - 1; left >= 0; left--) {
            int current = arr[left];
            ans[left] = maxSoFar;
            if (current > maxSoFar) {
                maxSoFar = current;
            }
            right--; // conceptually moves the "right" pointer inward
        }
        
        return ans;
    }
}