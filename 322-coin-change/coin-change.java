class Solution {
    int dp[][];
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n + 1][amount + 1];
        for(int i[]: dp) Arrays.fill(i, -1);

        int ans = solve(0,coins,amount);
        return (ans == (int)1e9 ? -1 : ans);
    }
    public int solve(int index,int[] coins,int amount)
    {
        if(amount < 0) return (int)1e9;

        if(index == coins.length)
        {
            return (amount == 0 ? 0 : (int)1e9);
        }

        if(dp[index][amount] != -1) return dp[index][amount];

        int notPick = solve(index + 1, coins, amount);
        int pick = (int)1e9;

        if(coins[index] <= amount) pick = 1 + solve(index, coins, amount - coins[index]);

        return dp[index][amount] = Math.min(notPick , pick);
    }
}