class Solution {
    int dp[][];
    public int minDistance(String word1, String word2) {
        if(word1.equals(word2)) return 0;

        int m = word1.length();
        int n = word2.length();
        dp= new int[m + 1][n + 1];
        for(int r[]: dp) Arrays.fill(r, -1);

        return solve(m - 1, n - 1, word1, word2);
    }
    public int solve(int i,int j,String s1, String s2){
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;

        if(dp[i][j] != -1) return dp[i][j];

        int ans = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            ans = solve(i - 1, j - 1, s1, s2);
        }else{
            int insert = 1 + solve(i, j - 1, s1, s2);
            int replace = 1 + solve(i - 1, j - 1, s1, s2);
            int delete = 1 + solve(i - 1, j, s1, s2);
            ans = Math.min(insert, Math.min(replace, delete)); 
        }
        return dp[i][j] = ans;
    }
}