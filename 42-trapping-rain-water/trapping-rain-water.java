class Solution {
    public int trap(int[] height) {
        // brute;
        int ans = 0;
        int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        int lmax = 0;
        
        for(int i = 0; i < n; i++){
            lmax = Math.max(lmax, height[i]);
            left[i] = lmax;
        }
        int rmax = 0;
        for(int i = n - 1; i >= 0; i--){
            rmax = Math.max(rmax, height[i]);
            right[i] = rmax;
        }
        for(int i = 0; i < n; i++){
            ans += Math.min(left[i] , right[i]) - height[i];
        }
        return ans;
    }
}