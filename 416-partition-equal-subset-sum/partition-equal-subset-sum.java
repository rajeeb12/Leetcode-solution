class Solution {
    Boolean dp[][];
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalsum = 0;
        for(int i : nums) totalsum += i;

        if(totalsum % 2 == 1) return false;

        dp = new Boolean[n +1][(totalsum / 2) + 1];

        return solve(0,n, nums,totalsum / 2);
    }
    public boolean solve(int index,int n, int[] nums,int totalsum)
    {
        if(totalsum == 0) return true;

        if(index == n)
        {
            return false;
        }

        if(dp[index][totalsum] != null) return dp[index][totalsum];

        boolean pick = false;
        boolean notpick =solve(index + 1, n, nums, totalsum);
        if(nums[index] <= totalsum)
        {
            pick = solve(index + 1, n, nums, totalsum - nums[index]);
        }

        return dp[index][totalsum] = (pick || notpick);
    }
}