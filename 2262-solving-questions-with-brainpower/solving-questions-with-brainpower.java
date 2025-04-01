class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long dp[] = new long[n + 1];
        Arrays.fill(dp, -1);
        return solve(0, questions, dp);
    }
    public long solve(int index,int questions[][],long dp[]){
        if(index >= questions.length) return 0;

        if(dp[index] != -1) return dp[index];

        if(dp[index] != -1) return dp[index];

        long pick = questions[index][0] + solve(index + questions[index][1] + 1, questions, dp);
        long skip = 0 + solve(index + 1, questions, dp);

        return dp[index] = Math.max(pick, skip);
    }
}