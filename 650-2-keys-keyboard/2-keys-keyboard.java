class Solution {
    int dp[];
    public int minSteps(int n) {
        dp = new int[n  + 1];
        Arrays.fill(dp, -1);
        return solve(n);
    }
    public int solve(int n){
        if(n == 1) return 0;

        if(dp[n] != -1) return dp[n];

        int res = n;
        for(int i = n / 2; i >= 1; i--){
            if(n % i == 0){
                res = Math.min(res, 1 + solve(i) + (n / i) - 1);
                break;
            }
        }
        return dp[n] = res;
    }
}