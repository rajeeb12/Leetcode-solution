//Memo
public class Solution {
    static int dp[];
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int n= nums.size()-1;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,nums);
	}
    public static int solve(int index,ArrayList<Integer> nums)
    {
        if(index==0)
            return nums.get(index);
        if(index<0)
            return 0;
        
        if(dp[index] != -1)
            return dp[index];
        
        int adj1 =nums.get(index) + solve(index-2,nums);
        int adj2 = 0 +  solve(index-1,nums); 
        dp[index]= Math.max(adj1,adj2);
        
        return dp[index];
    }
}
//Top down
public static int solve(int index,ArrayList<Integer> nums)
    {
        dp[0] =nums.get(0);
        int n = dp.length;
        for(int i=1; i<n; i++)
        {
            int pick= nums.get(i);
            if(i>1)
                pick += dp[i-2];
            int nonPick = dp[i-1];
            dp[i]= Math.max(pick,nonPick);
        }
        return dp[n-1];
    }
//spaceoptimization
public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
    int prev1= nums.get(0);
    int prev2=0,curi=0;
    int n = nums.size();
    for(int i=1; i<n; i++)
    {
        int take= nums.get(i);
        if(i>1)
            take += prev2;
        int nonTake= prev1;
        
        curi= Math.max(take,nonTake);
        prev2= prev1;
        prev1= curi;
    }
    return prev1;
}