class Solution {
    int dp[][];
    int mod = (int)1e9 + 7;
    public int knightDialer(int n) {
        if(n == 1) return 10;
        dp = new int[n+1][10];
        int[][] adj =  
        {
            {4,6},
            {6,8},
            {7,9},
            {4,8},
            {0,3,9},
            {},
            {0,1,7},
            {2,6},
            {1,3},
            {2,4},
        };
        int ans = 0;
        for(int cell = 0; cell <= 9; cell++)
        {
            dp[0][cell] = 1; 
        }
        
        for(int len = 1; len < n ; len++)
        {
            for(int cell = 0 ; cell <= 9; cell++)
            {
                int result = 0;
                for(int adjCell : adj[cell]){
                    result = (result + dp[len - 1][adjCell]) % mod;
                }
                dp[len][cell] = result;

                ans = (ans + dp[n-1][cell]) % mod;
            }
        }
        return ans;
    }
    public int solve(int len , int cell,int[][] adj)
    {
        if(len == 0){
            return 1;
        }
        if(dp[len][cell] != -1) return dp[len][cell];

        int result = 0;
        for(int adjCell : adj[cell]){
            result = (result + solve(len - 1, adjCell, adj)) % mod;
        }
        dp[len][cell] = result;
        return dp[len][cell];
    }
}