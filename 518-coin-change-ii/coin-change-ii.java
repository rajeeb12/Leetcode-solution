class Solution {
    int dp[][];
    public int change(int a, int[] coins) {
        int n = coins.length;
        dp = new int[coins.length + 1][a + 1];
        
        for(int i = 0; i < n; i++)
        {
            dp[i][0] = 1;
        }
        for(int index = n - 1; index >= 0; index--){
            for(int amount = 1; amount <= a; amount++){

                int notpick = dp[index + 1][amount];
                int pick = 0;

                if(coins[index] <= amount){
                    pick = dp[index][amount - coins[index]];
                }

                dp[index][amount] = notpick + pick;
            }
        }
        return dp[0][a];
        //return solve(0,coins,amount);
    }
    // public int solve(int index,int[] coins,int amount)
    // {
    //     if(amount == 0) return 1;
    //     if(index == coins.length) return 0;
        
    //     if(dp[index][amount] != -1) return dp[index][amount];

    //     int notpick = solve(index + 1, coins, amount);
    //     int pick = 0;

    //     if(coins[index] <= amount){
    //         pick = solve(index , coins, amount - coins[index]);
    //     }

    //     return dp[index][amount] = notpick + pick;
    // }
}