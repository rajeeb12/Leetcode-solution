class Solution {
    int dp[];
    public int numSquares(int limit) {
        dp = new int[limit + 1];

        for(int n = 1; n <= limit; n++){
            int take = (int)1e9;
            for(int number = 1; number * number <= n; number++){
                take = Math.min(take, 1 + dp[n - (number * number)]);
            }
            dp[n] = take;
        }
        return dp[limit];
    }
}