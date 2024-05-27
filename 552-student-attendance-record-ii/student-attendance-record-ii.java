class Solution {
    int mod;
    int dp[][][];
    public int checkRecord(int n) {
        dp = new int[n + 1][2][3];
        
        // for(int i[][]: dp){
        //     for(int j[]: i){
        //         Arrays.fill(j, -1);
        //     }
        // }
        mod = (int)1e9 + 7;
        
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                dp[0][i][j] = 1;
            }
        }

        for(int index = 1; index <= n; index++){
            for(int a = 1; a >= 0; a--){
                for(int l = 2; l >= 0; l--){
                    int pick_a = 0, pick_l = 0, pick_p = 0;
                    if(a + 1 < 2) pick_a = dp[index - 1][a + 1][0];
                    if(l + 1 < 3) pick_l = dp[index - 1][a][l + 1];
                    pick_p = dp[index - 1][a][0];

                    dp[index][a][l] = ((pick_a + pick_l) % mod + pick_p) % mod;
                }
            }
        }

        return dp[n][0][0];
        //return solve(n,0,0);
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