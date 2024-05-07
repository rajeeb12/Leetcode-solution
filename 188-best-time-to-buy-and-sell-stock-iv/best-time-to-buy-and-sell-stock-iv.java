class Solution {
    int dp[][][];
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        dp = new int[n + 1][k + 1][2];
        for(int mat[][]: dp)
        {
            for(int i[]: mat)
            {
                Arrays.fill(i, - 1);
            }
        }
        return solve(0,k,prices,n,1);
    }
    public int solve(int index,int k,int[] prices,int n,int bos)
    {
        if(k == 0 || index == n) return 0;
        
        if(dp[index][k][bos] != -1) return dp[index][k][bos];
        
        if(bos == 1){
            return dp[index][k][bos] = Math.max(-prices[index] + solve(index + 1, k,prices,n,bos - 1), solve(index + 1,k,prices,n,bos));
        }else{
            return dp[index][k][bos] = Math.max(prices[index] + solve(index + 1, k - 1,prices,n, 1 - bos), solve(index + 1,k,prices,n, bos));   
        }
    }
}