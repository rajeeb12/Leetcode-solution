class Solution {
    int dp[][];
    public int longestPalindromeSubseq(String s) {
        StringBuilder str1 = new StringBuilder(s);
        StringBuilder str2 = new StringBuilder(s);
        str2.reverse();
        int n = s.length();
        dp = new int[n + 1][n + 1];
        for(int i[]: dp)
        {
            Arrays.fill(i, -1);
        }
        return solve(n - 1, n - 1,str1.toString(), str2.toString());
    }
    public int solve(int i,int j,String s,String t)
    {
        if(i < 0 || j < 0) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j))
        {
            return dp[i][j] = 1 + solve(i - 1, j - 1, s, t);
        } 
        else{
            return dp[i][j] = Math.max(solve(i - 1, j, s, t), solve(i, j - 1,s,t));
        }
    }
}