class Solution {
    int dp[][][];
    public int maximumLength(int[] nums, int k) {
        dp = new int[nums.length + 1][nums.length + 1][k + 1];
        for(int i[][] : dp)
        {
            for(int j[]: i){
                Arrays.fill(j, -1);
            }
        }
        return solve(0, -1, nums, k);
    }
    public int solve(int index, int pIndex,int nums[],int k){
        if(index == nums.length) return 0;

        if(dp[index][pIndex + 1][k] != -1) return dp[index][pIndex + 1][k];
        
        int ans = 0;
        if(pIndex == -1 || nums[index] == nums[pIndex]){
            ans = Math.max(ans, 1 + solve(index + 1, index, nums, k));
            ans = Math.max(ans, solve(index + 1, pIndex, nums, k));
        }else if(nums[index] != nums[pIndex]){
            if(k > 0){
                ans = Math.max(ans , 1 + solve(index + 1, index , nums, k - 1));
            }
            ans = Math.max(ans, solve(index + 1, pIndex, nums, k));
        }

        return dp[index][pIndex + 1][k] = ans;
    }
}