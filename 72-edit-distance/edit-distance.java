class Solution {
    int dp[][];
    public int minDistance(String word1, String word2) {
        if(word1.equals(word2)) return 0;

        int m = word1.length();
        int n = word2.length();
        dp= new int[m + 1][n + 1];
        for(int i = 0; i <= n; i++) dp[0][i] = i;
        for(int j = 0; j <= m; j++) dp[j][0] = j;

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                int ans = 0; 
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    ans = dp[i - 1][j - 1];
                }else{
                    int insert = dp[i][j -1];
                    int replace = dp[i - 1][j - 1];
                    int delete = dp[i - 1][j];
                    ans = 1 + Math.min(insert, Math.min(replace, delete)); 
                }
                dp[i][j] = ans;
            }
        }

        return dp[m ][n ];
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