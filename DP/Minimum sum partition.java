//Recursive
public int minimumDifference(int[] nums) {
    int range=0;
    for(int x : nums)
        range += x;
    int n=nums.length;
    return solve(nums,range,n-1,0);
}
public static int solve(int[] nums,int range,int n,int totalSum)
{
    if(n==0)
    {
        return Math.abs(range - 2 * totalSum);
    }
    
    return Math.min(solve(nums,range,n-1,totalSum + nums[n-1]),solve(nums,range,n-1,totalSum));
}

//User function Template for Java
//Bottom up

class Solution
{
    public static ArrayList<Integer> solve(int[] arr,int n,int sum)
    {
        boolean[][] dp= new boolean[n+1][sum+1];
        
        for(int i=0; i<n+1; i++)
        {
            for(int j=0; j<sum+1; j++)
            {
                if(i==0)
                {
                    dp[i][j]= false;
                }
                if(j==0)
                {
                    dp[i][j]= true;
                }
            }
        }
        
        for(int i=1; i<n+1; i++)
        {
            for(int j=1; j<sum+1; j++)
            {
                if(arr[i-1] <= j)
                {
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else
                {
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        
        ArrayList<Integer> ds= new ArrayList<>();
        for(int i=0; i<=sum/2 ; i++)  //this where i was doing worng 
        {
            if(dp[n][i])
            {
                ds.add(i);
            }
        }
        return ds;
    }

	public int minDifference(int arr[], int n) 
	{ 
	    int range=0;
	    for(int i=0; i<n; i++)
	    {
	        range += arr[i];
	    }
	    ArrayList<Integer> res= solve(arr,n,range);
	    
	    int mn= Integer.MAX_VALUE;
	    for(int i=0; i<res.size(); i++)
	    {
	        mn = Math.min(mn, range- 2*res.get(i));
	    }

	    return mn;
	} 
}
