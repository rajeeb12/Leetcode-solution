class Solution {
    static int dp[];
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp= new int[arr.length];
        Arrays.fill(dp,-1);
        return solve(0,arr,k);
    }
    public static int solve(int index,int[] arr,int k)
    {
        if(index==arr.length) return 0;

        if(dp[index] != -1) return dp[index];
        int len=0;
        int max= -(int)1e9;
        int maxSum= -(int)1e9;
        for(int j=index; j< Math.min(arr.length, index + k) ; j++)
        {
            len++;
            max= Math.max(max,arr[j]);
            int sum= max * len + solve(j+1,arr,k);

            maxSum = Math.max(sum , maxSum);
        }
        dp[index]= maxSum;
        return dp[index];
    }
}