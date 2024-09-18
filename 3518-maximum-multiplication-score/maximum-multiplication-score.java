class Solution {
    long dp[][];
    public long maxScore(int[] a, int[] b) {
        dp = new long[5][b.length + 1];
        for(long i[]: dp) Arrays.fill(i, -1);

        return solve(0,0,a, b);
    }
    public long solve(int i,int j,int a[],int b[]){
        if(i == a.length) return 0;
        if(j >= b.length)  return -(long)1e18;

        if(dp[i][j] != -1) return dp[i][j];

        long notpick = solve(i,  j + 1, a, b);
        
        long pick =(long) a[i] * (long) b[j] + solve(i + 1, j + 1, a, b);

        return dp[i][j] = Math.max(pick, notpick);
    }
}