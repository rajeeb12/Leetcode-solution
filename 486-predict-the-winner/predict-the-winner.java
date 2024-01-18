class Solution {
    int dp[][];
    public boolean predictTheWinner(int[] nums) {
        
        int sum = 0;
        int n = nums.length;
        dp = new int[n + 1][n + 1];

        for(int i[] : dp) Arrays.fill(i, - 1);
        
        for(int i: nums) sum += i;

        int maxSump1 = solve(0, n-1, nums);

        int maxSump2 = sum - maxSump1;

        return (maxSump1 >= maxSump2);
    }
    public int solve(int i, int j, int[] nums)
    {
        if(i > j) return 0;

        if(i == j) return nums[i];

        if(dp[i][j] != -1) return dp[i][j];

        int take_i = nums[i] + Math.min(solve(i + 2, j , nums), solve(i + 1, j - 1, nums));

        int take_j = nums[j] + Math.min(solve(i , j - 2 , nums), solve(i + 1, j - 1, nums));

        return Math.max(take_i , take_j);
    }
}