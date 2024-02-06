class Solution {
    Boolean dp[][];
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        dp = new Boolean[n + 1][m + 1];
        
        return solve(n - 1, m - 1, s, p);
    }
    public boolean solve(int i,int j,String s,String p)
    {
        if(i < 0 && j < 0) return true;
        if(j < 0 && i >= 0 ) return false;
        if(i < 0 && j >= 0)
        {
            for(int start = 0; start <= j; start++)
            {
                if(p.charAt(start)!= '*')
                {
                    return false;
                }
            }
            return true;
        } 

        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
        {
            return dp[i][j] = solve(i - 1, j - 1, s,p);
        }
        else if(p.charAt(j) == '*')
        {
            return dp[i][j] = (solve(i , j - 1 , s, p ) || solve(i - 1 , j, s, p));
        }
        return false;
    }
}