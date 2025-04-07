class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for(int i: nums) sum += i;
        
        if(sum % 2 == 1) return false;

        int target = sum / 2;
        Boolean dp[][] = new Boolean[nums.length + 1][target + 1];

        return solve(nums.length - 1, target, nums, dp);
    }
    public boolean solve(int index,int target,int nums[],Boolean dp[][]){
        if(target < 0) return false;
        if(index < 0){
            if(target == 0) return true;
            return false;
        }
        if(dp[index][target] != null) return dp[index][target];

        boolean pick = solve(index - 1, target - nums[index], nums, dp);
        boolean skip = solve(index - 1, target, nums, dp);

        return dp[index][target] = pick || skip;
    }
}