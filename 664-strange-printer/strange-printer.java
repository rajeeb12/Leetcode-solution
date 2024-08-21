class Solution {
    int dp[][];
    public int strangePrinter(String s) {
        int n = s.length();
        dp = new int[n + 1][n + 1];
        for(int i[]: dp) Arrays.fill(i, -1);
        return solve(0, n - 1, s);
    }
    public int solve(int l,int r,String s){
        if(l > r) return 0;

        if(dp[l][r] != -1) return dp[l][r];

        int ans = 1 + solve(l + 1, r, s);
        for(int i = l + 1; i <= r; i++){
            if(s.charAt(i) == s.charAt(l)){
                ans = Math.min(ans, solve(l, i - 1, s) + solve(i + 1, r, s));
            }
        }
        return dp[l][r] = ans;
    }
}