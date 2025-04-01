class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long dp[] = new long[200001];

        for(int index = n - 1; index >= 0; index--)
        {
            long pick = 0, skip = 0;
            pick = questions[index][0] + dp[index + questions[index][1] + 1];
            skip = 0 + dp[index + 1];

            dp[index] = Math.max(pick , skip);
        }
        return dp[0];
        //return solve(0, questions, dp);
    }
    public long solve(int index,int questions[][],long dp[]){
        if(index >= questions.length) return 0;

        if(dp[index] != -1) return dp[index];

        long pick = questions[index][0] + solve(index + questions[index][1] + 1, questions, dp);
        long skip = 0 + solve(index + 1, questions, dp);

        return dp[index] = Math.max(pick, skip);
    }
}