class Solution {
    int n;
    int dp[][];
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n + 2][2];
        int front1[] = new int[2];
        int front2[] = new int[2];
        int cur[] = new int[2];

        for(int i = n - 1; i >= 0; i--)
        {
            for(int buy = 0 ; buy <=1; buy++)
            {
                if(buy == 0)
                {
                    cur[buy] = Math.max(-prices[i] + front1[1], front1[0]);
                }
                if(buy == 1)
                {
                    cur[buy] = Math.max(prices[i] + front2[0] , front1[1]);
                }
            }
            System.arraycopy(front1, 0, front2, 0, 2);
            System.arraycopy(cur, 0, front1, 0, 2);
        }
        return cur[0];
        //return solve(0, prices,0);
    }
    // 0 - > sell , 1 -> buy
    public int solve(int i,int[] prices,int buy)
    {
        if(i >= n) return 0;

        if(dp[i][buy] != -1) return dp[i][buy];

        if(buy == 0)
        {
            return dp[i][buy] = Math.max(-prices[i] + solve(i + 1, prices, 1) , solve(i + 1, prices, 0));
        }
        else{
            return dp[i][buy] = Math.max(prices[i] + solve(i + 2, prices, 0) , solve(i + 1, prices, 1));
        }
    }
}