class Solution {
    int dp[][];
    public int longestCommonSubsequence(String str1, String str2) {

        int n1 = str1.length();
        int n2 = str2.length();
        dp = new int[n1 + 1][n2 + 1];

        for(int i1 = 1 ; i1 <= n1; i1++)
        {
            for(int i2 = 1 ; i2 <= n2; i2++)
            {
                int pick = 0;
                int notPick = 0;
                if(str1.charAt(i1 - 1) == str2.charAt(i2 - 1))
                {
                    pick = 1 + dp[i1 - 1][i2 - 1];
                }
                notPick = Math.max(dp[i1 - 1][i2] , dp[i1][i2 - 1]);

                dp[i1][i2] = Math.max(pick, notPick);
            }
        }

        //return solve(text1, text2, n1 - 1, n2 -1);
        return dp[n1][n2];    
    }
    public int solve(String str1, String str2,int i1,int i2)
    {
        if(i1 < 0 || i2 < 0) return 0;
        
        if(dp[i1][i2] != -1) return dp[i1][i2];

        int pick = 0;
        int notPick = 0;
        if(str1.charAt(i1) == str2.charAt(i2))
        {
            pick = 1 + solve(str1, str2, i1 - 1, i2 - 1);
        }
        notPick = Math.max(solve(str1, str2, i1 - 1, i2) , solve(str1, str2, i1, i2 -1));

        return dp[i1][i2] = Math.max(pick, notPick);
    }
}