class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if(k == 1) return nums;
        
        int n = nums.length;

        int dp[] = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i - 1] + 1){
                dp[i] = dp[i - 1] + 1;
            }else{
                dp[i] = 1;
            }
        }
        int ans[] = new int[n - k + 1];
        int it = 0;
        for(int i = k - 1; i < n; i++)
        {
            ans[it++] = (dp[i] < k ? -1 : nums[i]);
        }
        return ans;
    }
}