class Solution {
    int dp[][];
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n + 1][amount + 1];
        for(int i[]: dp)
        {
            Arrays.fill(i, -1);
        }
        int ans = solve(0, coins, amount);
        return (ans == (int)1e9 ? -1 : ans);
    }
    public int solve(int index, int[] coins,int amt)
    {
        if(index == coins.length)
        {
            if(amt == 0)
            {
                return 0;
            }
            return (int)1e9;
        }
        
        if(dp[index][amt] != -1) return dp[index][amt];

        int notPick = solve(index + 1,coins, amt);
        int pick = (int)1e9;
        if(coins[index] <= amt)
        {
            pick = 1 + solve(index , coins , amt - coins[index]);
        }
        return dp[index][amt] = Math.min(notPick , pick);
    }
}