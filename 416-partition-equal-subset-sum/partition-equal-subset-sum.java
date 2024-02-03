class Solution {
    boolean dp[][];
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalsum = 0;
        for(int i : nums) totalsum += i;

        if(totalsum % 2 == 1) return false;

        dp = new boolean[n +1][(totalsum / 2) + 1];
        totalsum /= 2;

        for(int i = 0; i < n ; i++)
        {
            dp[i][0] = true;
        }

        for(int index = n - 2 ; index >= 0; index--)
        {
            for(int t = 0 ; t <= totalsum; t++)
            {
                boolean pick = false;
                boolean notpick = dp[index + 1][t];
                if(nums[index] <= t)
                {
                    pick = dp[index + 1][t - nums[index]];
                }

                dp[index][t] = (pick || notpick);
            }
        }
        return dp[0][totalsum];
        //return solve(0,n, nums,totalsum / 2);
    }
    // public boolean solve(int index,int n, int[] nums,int t)
    // {
    //     if(t == 0) return true;

    //     if(index == n)
    //     {
    //         return false;
    //     }

    //     if(dp[index][t] != null) return dp[index][t];

    //     boolean pick = false;
    //     boolean notpick =solve(index + 1, n, nums, t);
    //     if(nums[index] <= t)
    //     {
    //         pick = solve(index + 1, n, nums, t - nums[index]);
    //     }

    //     return dp[index][t] = (pick || notpick);
    // }
}