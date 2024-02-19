class Solution {
    Boolean dp[][];
    public boolean canPartition(int[] nums) {
        int n = nums.length;
       
        int totalsum = 0;
        for(int i : nums)
        {
            totalsum += i;
        }
        if(totalsum % 2 != 0) return false;
        totalsum /= 2;
        dp = new Boolean[n + 1][totalsum + 1];

        return solve(0, nums, totalsum);
    }
    public boolean solve(int index,int[] nums,int target)
    {
        if(index == nums.length)
        {
            if(target == 0)
            {
                return true;
            }
            return false;
        }
        if(dp[index][target] != null) return dp[index][target];

        boolean notpick = solve(index + 1, nums, target);
        boolean pick = false;
        if(nums[index] <= target)
        {
            pick = solve(index + 1, nums, target - nums[index]);
        }
        return dp[index][target] = (pick || notpick); 

    }
}