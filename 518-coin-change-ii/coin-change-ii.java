class Solution {
    int dp[][];
    public int change(int amount, int[] coins) {
        dp = new int[coins.length + 1][amount + 1];
        for(int i[]: dp) Arrays.fill(i, -1);

        return solve(0,coins,amount);
    }
    public int solve(int index,int[] coins,int amount)
    {
        if(amount == 0) return 1;
        if(index == coins.length) return 0;
        
        if(dp[index][amount] != -1) return dp[index][amount];

        int notpick = solve(index + 1, coins, amount);
        int pick = 0;

        if(coins[index] <= amount){
            pick = solve(index , coins, amount - coins[index]);
        }

        return dp[index][amount] = notpick + pick;
    }
}