class Solution {
    //int dp[][];
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //dp = new int[n + 1][2];
        int cur[]= new int[2];
        int next[] = new int[2];  
        for(int i = n - 1; i >=0 ; i--)
        {
            for(int buyOrSell = 0 ; buyOrSell <= 1; buyOrSell++)
            {
                int profit = 0;
                if(buyOrSell == 1)
                {
                    profit = Math.max(-prices[i] + next[1 - buyOrSell] , next[buyOrSell]);
                }
                else{
                    profit = Math.max(prices[i] + next[1 -buyOrSell] , next[buyOrSell]);
                }
                cur[buyOrSell] = profit;
            }
            next = cur;
        }
        return cur[1];
        //return solve(0, prices, 1);
    }
    // public int solve(int i, int prices[], int buyOrSell)
    // {
    //     int n = prices.length; 
    //     if(i == n)
    //     {
    //         return 0;
    //     }
    //     if(dp[i][buyOrSell] != -1) return dp[i][buyOrSell];

    //     if(buyOrSell == 1)
    //     {
    //         return dp[i][buyOrSell] =Math.max(-prices[i] + solve(i + 1, prices, 1 - buyOrSell) , solve(i + 1, prices,buyOrSell));
    //     }
    //     else{
    //         return dp[i][buyOrSell]= Math.max(prices[i] + solve(i + 1, prices, 1 - buyOrSell) , solve(i + 1, prices, buyOrSell));
    //     }
    // }
}