class Solution {
    int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new int[n + 1][m + 1];
        
        for(int r[]: dp) Arrays.fill(r, -1);

        return solve(0,0,text1, text2);
    }
    public int solve(int i,int j,String t1, String t2){
        if(i >= t1.length() || j >= t2.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        if(t1.charAt(i) == t2.charAt(j)){
            ans = 1 + solve(i + 1, j + 1, t1, t2);
        }else{
            ans = Math.max(solve(i + 1,j, t1, t2) , solve(i, j + 1, t1, t2));
        }

        return dp[i][j] = ans;
    }
}