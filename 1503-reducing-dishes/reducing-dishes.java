class Solution {
    int dp[][];
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        dp = new int[n + 1][n + 2];
        for(int i[]: dp) Arrays.fill(i, -1);
        
        return solve(0,1,satisfaction);
    }
    public int solve(int index,int count,int[] s){
        if(index == s.length ) return 0;

        if(dp[index][count] != -1) return dp[index][count];

        int ans = 0;
        for(int i = index; i < s.length; i++){
            ans = Math.max(ans, s[i] * count + solve(i + 1, count + 1, s));
        }
        return dp[index][count] = ans;
    }
}