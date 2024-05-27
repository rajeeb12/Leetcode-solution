class Solution {
    int mod;
    int dp[][][];
    public int checkRecord(int n) {
        dp = new int[n + 1][2][3];
        
        for(int i[][]: dp){
            for(int j[]: i){
                Arrays.fill(j, -1);
            }
        }
        mod = (int)1e9 + 7;
        return solve(n,0,0);
    }
    public int solve(int n,int a,int l){

        if(a >= 2 || l >= 3) return 0;

        if(n == 0)
        {
            return 1;
        }
        if(dp[n][a][l] != -1) return dp[n][a][l];

        int pick_a = solve(n - 1, a + 1, 0);
        int pick_l = solve(n - 1 , a , l + 1) % mod;
        int pick_p = solve(n - 1, a, 0);

        return dp[n][a][l] = ((pick_a + pick_l) % mod + pick_p) % mod; 
    }
}