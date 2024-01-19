class Solution {
    int dp[];
    public int rob(int[] nums) {
        int n = nums.length; 
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        dp = new int[n + 1];
        
        dp[0] = nums[0];
        int pp = 0;
        int p = nums[0];

        for(int index = 1; index < n ; index++)
        {
            int rob = nums[index];
            if(index > 1) rob += pp;
            int notRob = p;

            int cur = Math.max(rob, notRob);
            pp = p;
            p = cur;
        }
        
        return p;
    }
}