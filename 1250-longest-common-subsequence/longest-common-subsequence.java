class Solution {
    int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new int[n + 1][m + 1];
        for(int i[]: dp) Arrays.fill(i, -1);

        int ans = 0;
        for(int i = n - 1; i >=0 ; i--){
            for(int j = m - 1; j >= 0; j--){
                ans = Math.max(ans, solve(i,j, text1 , text2));
            }
        }
        return ans;
    }
    public int solve(int i,int j,String s1,String s2){
        if(i < 0 || j < 0) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
    
        int ans = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            ans = 1 + solve(i - 1, j - 1, s1, s2); 
        }else{
            int a = solve(i - 1, j, s1 ,s2);
            int b = solve(i , j - 1, s1, s2);
            ans = Math.max(ans, Math.max(a, b));
        }
        return dp[i][j] = ans;
    }
}