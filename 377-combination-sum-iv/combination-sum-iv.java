class Solution {
    int dp[];
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        dp = new int[target + 1];
        Arrays.fill(dp, -1);

        return solve(target, nums);
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