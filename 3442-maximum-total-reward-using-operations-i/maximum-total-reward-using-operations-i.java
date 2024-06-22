class Solution {
    int dp[][];
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int n = rewardValues.length;
        dp = new int[n + 1][4001];
        for(int i[]: dp) Arrays.fill(i, -1);
        return solve( 0, 0, rewardValues);   
    }
    public int solve(int index,int sum,int[] r){
        if(index >= r.length) return sum;
        
        if(dp[index][sum] != -1) return dp[index][sum];

        int pick = 0;
        if(sum < r[index])
        {
            pick = solve(index + 1, sum + r[index], r);
        }
        int notPick = solve(index + 1, sum, r);
        return dp[index][sum] = Math.max(notPick , pick);
    }
}