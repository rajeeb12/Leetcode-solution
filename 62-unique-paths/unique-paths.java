class Solution {
    int di[] = {0,1};
    int dj[] = {1,0};
    int dp[][];
    public int uniquePaths(int m, int n) {
        dp = new int[m + 1][n + 1];
        for(int r[]: dp) Arrays.fill(r, -1);

        return solve(0,0,m - 1, n - 1);
    }
    public int solve(int i,int j,int m,int n){
        if(i == m && j == n) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        int ans = 0;
        for(int k = 0; k < 2; k++){
            int ni = i + di[k];
            int nj = j + dj[k];
            if(ni <= m && nj <= n){
                ans += solve(ni, nj, m, n);
            }
        }
        return dp[i][j] = ans;
    }
}