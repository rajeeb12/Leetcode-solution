class Solution {
    int dp[][];
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n + 1][amount + 1];
        for(int i[] : dp) Arrays.fill(i, (int)1e9);
        
        dp[n][0] = 0;
        for(int amt = 0; amt <= amount; amt++){
            for(int i = n - 1; i >= 0; i--){
                int notPick = dp[i + 1][amt];
                int pick = (int)1e9;
                if(coins[i] <= amt){
                    pick = 1 + dp[i][amt - coins[i]];
                }
                dp[i][amt] = Math.min(pick , notPick);
            }
        }
        return (dp[0][amount] == (int)1e9 ? -1 : dp[0][amount]);

        //return (ans == (int)1e9 ? -1 : ans);
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