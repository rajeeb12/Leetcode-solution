class Solution {
    int dp[];
    public int combinationSum4(int[] nums, int tar) {
        int n = nums.length;
        dp = new int[tar + 1];

        dp[0] = 1;

        for(int target = 1; target <= tar; target++){
            int sum = 0;
            for(int j = 0; j < nums.length; j++)
            {
                int pick = 0; 
                if(nums[j] <= target) pick = dp[target - nums[j]];
                sum += pick;
            }
            dp[target] = sum;
        }
        return dp[tar];
        //return solve(target, nums);
    }
    public int solve(int target,int[] nums){
        if(target == 0) return 1;
        if(target < 0) return 0;

        if(dp[target] != -1) return dp[target];

        int sum = 0;
        for(int j = 0; j < nums.length; j++)
        {
            int pick = solve(target - nums[j], nums);
            sum += pick;
        }
        return dp[target] = sum;
    }
}