class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 0 1 2 3 index
        // 1 2 3 4
        // 1 2 6 24 prefix
        // 24 24 12 4 suffix
        // 1 index -> 0th prefix * 2nd index suffix;
        int n = nums.length;
        int prefix[] = new int[n]; 
        int suffix[] = new int[n];
        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];
        for(int i = 1; i < n - 1; i++){
            prefix[i] = prefix[i - 1] * nums[i];
        }
        for(int i = n - 2; i >= 0; i--){
            suffix[i] = suffix[i + 1] * nums[i];
        }
        int ans[] = new int[n];
        ans[0] = suffix[1];
        ans[n - 1] = prefix[n - 2];
        for(int i = 1; i < n - 1; i++){
            ans[i] = prefix[i - 1] * suffix[i + 1];
        }
        return ans;
    }
}