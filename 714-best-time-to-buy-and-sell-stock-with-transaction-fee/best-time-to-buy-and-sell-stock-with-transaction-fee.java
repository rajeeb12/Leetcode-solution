class Solution {
    int dp[][];
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        dp = new int[n + 1][2];
        for(int r[]: dp) Arrays.fill(r, -1);

        return solve(0,prices, fee, 0);
    }
    public int solve(int i,int prices[],int fee,int k){
        if(i >= prices.length) return 0;

        if(dp[i][k] != -1) return dp[i][k];

        int ans = 0;

        if(k == 0){
            ans += Math.max(solve(i + 1, prices, fee, 1 - k) - prices[i], solve(i + 1,  prices, fee, k));  
        }else{
            ans += Math.max((prices[i] - fee) + solve(i + 1, prices, fee, 1 - k), solve(i + 1,  prices, fee, k));
        }

        return dp[i][k] = ans;
    }
}