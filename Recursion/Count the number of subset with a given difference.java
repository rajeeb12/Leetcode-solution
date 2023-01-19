import java.util.* ;
import java.io.*; 
public class Solution {
    static int mod=1000000007;
    public static int count(int n,int sum,int[] arr)
    {
        int dp[][]= new int[n+1][sum+1];
        for(int i=0; i<n+1; i++)
        {
            for(int j=0; j<sum+1; j++)
            {
                if(i==0)
                    dp[i][j]=0;
                if(j==0)
                    dp[i][j]=1;
            }
        }
        for(int i=1; i<n+1; i++)
        {
            for(int j=0; j<sum+1; j++)
            {
                if(arr[i-1] <= j)
                {
                    dp[i][j]= (dp[i-1][j-arr[i-1]] + dp[i-1][j]) % mod;
                }
                else
                {
                    dp[i][j]= (dp[i-1][j]) % mod;
                }
            }
        }
        return dp[n][sum] % mod;
    }
	public static int countPartitions(int n, int d, int[] arr) {
		int sumArr=0;
        for(int i=0; i<n; i++)
        {
            sumArr += arr[i];
        }
        if((sumArr-d) < 0 || (sumArr-d)%2==1)
            return 0;
        
        return count(n,(sumArr+d)/2,arr);
	}
}