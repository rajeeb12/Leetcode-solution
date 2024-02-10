class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n + 1];
        int count[] = new int[n + 1];
        int max = 1;
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        for(int i = 0; i < n ; i++)
        {
            for(int pi = 0; pi < i; pi++)
            {
                if(arr[pi] < arr[i] && dp[i] < dp[pi] + 1)
                {
                    dp[i] = dp[pi] + 1;
                    count[i] = count[pi];
                }
                else if(arr[pi] < arr[i] && dp[pi] + 1 == dp[i])
                {
                    count[i] = count[pi] + count[i];
                }
                max = Math.max(max, dp[i]);
            }
        } 
        int nos = 0;
        for(int i = 0 ; i < n; i++)
        {
            if(max == dp[i])
            {
                nos += count[i];
            }
        }
        return nos;
    }
}