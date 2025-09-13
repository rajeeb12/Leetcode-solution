class Solution {
    int dp[];
    public int rob(int[] nums) {
        int n = nums.length;
        
        if(n == 1) return nums[0];

        int prev2 = nums[0], prev1 = Math.max(nums[0],nums[1]);

        for(int index = 2; index < n ; index++){
            int notPick = prev1;
            int pick = nums[index] + prev2;
            int cur = Math.max(notPick, pick);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
    
}