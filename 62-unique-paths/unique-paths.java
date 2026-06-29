class Solution {
    int di[] = {0,1};
    int dj[] = {1,0};
    int dp[][];
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];

        dp[m - 1][n - 1] = 1;

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 && j == n - 1) continue;
                int down = 0, right = 0;
                if(i + 1 < m){
                    down = dp[i + 1][j];
                }
                if(j + 1 < n ){
                    right = dp[i][j + 1];
                }
                dp[i][j] = down + right;
            }
        }

        return dp[0][0];
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