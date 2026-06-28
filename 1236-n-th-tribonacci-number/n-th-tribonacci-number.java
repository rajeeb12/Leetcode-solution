class Solution {
    int dp[];
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;

        int prev1 = 0, prev2 = 1, prev3 = 1;

        for(int i = 3; i <= n; i++){
            int curr = prev1 + prev2 + prev3;
            prev1 = prev2;
            prev2 = prev3;
            prev3 = curr;
        } 

        return prev3;
    }
    public int solve(int n){
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        
        if(dp[n] != -1) return dp[n];

        dp[n] = solve(n - 1) + solve(n - 2) + solve(n - 3);

        return dp[n];
    }
}