class Solution {
    public String longestPalindrome(String s) {
        int dp[][] = new int[1001][1001];

        for(int i[]: dp) Arrays.fill(i, -1);

        int n = s.length(), start = -1, end = -1, max = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(solve(i, j, s, dp) == 1 && j - i + 1 > max){
                    start = i;
                    end = j;
                    max = j - i + 1;
                }
            }
        }
        if(start != -1) return s.substring(start, end + 1);
        return "";
    }
    public int solve(int i,int j,String s,int dp[][]){
        if(i > j) return 1;
        
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = solve(i + 1, j - 1, s, dp);
        }
        return dp[i][j] = 0;
    }
}