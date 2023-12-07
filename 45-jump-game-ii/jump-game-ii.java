class Solution {
  int dp[];
    public int jump(int[] nums) {
        dp = new int[nums.length +1];
        Arrays.fill(dp,-1);
        return solve(0,nums);
    }
    public int solve(int index,int[] nums)
    {
        if(index >= nums.length-1)
        {
            return 0;
        }

        if(dp[index] != -1) return dp[index];

        if(nums[index] == 0) return (int)1e9;
        
        int minStep = (int)1e9;
        for(int i = 1 ; i <= nums[index] ; i++)
        {
          minStep = Math.min(minStep , 1 + solve(index + i, nums));
        }
        return dp[index] = minStep;
    }
}