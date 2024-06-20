class Solution {
    int dp[][];
    public int twoEggDrop(int n) {
        dp = new int[3][n + 1];
        for(int i[]: dp) Arrays.fill(i, -1);
        return solve(2,n);
    }
    public int solve(int e,int f){
        if(f == 0 || f == 1) return f;
        if(e == 1) return f;

        if(dp[e][f] != -1) return dp[e][f];

        int ans = (int)1e9;

        for(int k = 1; k <= f; k++){
            int temp = 1 + Math.max(solve(e - 1, k - 1) , solve(e, f - k));
            ans = Math.min(ans, temp);
        }
        return dp[e][f] = ans;
    }
}