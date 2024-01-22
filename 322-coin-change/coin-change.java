class Solution {
    int dp[][];
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        int n = coins.length;
        dp = new int[n + 1][amount + 1];
        for(int i[] : dp) Arrays.fill(i, -1);

        int ans = helper(coins, 0,amount);

        return (ans == (int)1e9 ? -1: ans);
    }
    public int helper(int[] coins,int index, int amount)
    {
        if(index == coins.length)
        {
            return (amount == 0 ? 0 : (int)1e9);
        }

        if(dp[index][amount] != -1) return dp[index][amount];

        int notPick = helper(coins, index + 1, amount);
        int pick = (int)1e9;
        if(coins[index] <= amount)
            pick = 1 + helper(coins, index, amount - coins[index]);

        return dp[index][amount] = Math.min(notPick , pick);
    }
}