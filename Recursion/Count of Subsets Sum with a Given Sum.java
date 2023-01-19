class Solution{
    //I would need mod to keep the ans in range
    static int mod= 1000000007;
    public int countSubSet(int arr[],int n,int sum,int[][] dp)
    {
        for(int i=1; i<n+1; i++)
        {
            for(int j=0; j<sum+1; j++)
            {
                if(arr[i-1] <= j)
                {
                    dp[i][j]= (dp[i-1][j-arr[i-1]] + dp[i-1][j])%mod;
                }
                else 
                {
                    dp[i][j]= dp[i-1][j] % mod;
                }
            }
        }
        return dp[n][sum] % mod;
    }
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    int[][] dp= new int[n+1][sum+1];
	    
	    for(int i=0; i <sum+1; i++)
	    {
	        dp[0][i]=0;
	    }
	    dp[0][0]=1; //because If the sum is 0 then there exists null subset {} whose sum is 0
	    
	    return countSubSet(arr,n,sum,dp);
	} 
}
#note: 
The problem is, that initializing the entire column with 1 will work only if the input array has all non-zero elements. 