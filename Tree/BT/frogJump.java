//Recursive
public class Solution {
    public static int frogJump(int n, int heights[]) {
        
        return solve(n-1,heights);
        
    }
    public static int solve(int n,int[] heights)
    {
        if(n==0)
            return 0;
        int jumpOne=Math.abs(heights[n] - heights[n-1]) + solve(n-1,heights);
        int jumpTwo=Integer.MAX_VALUE;
        if(n>1)
            jumpTwo = Math.abs(heights[n]-heights[n-2]) + solve(n-2,heights);
       
        return Math.min(jumpOne,jumpTwo);
    }
}
//Memomization
public static int frogJump(int n, int heights[]) {
        
    return solve(n-1,heights);
    
}
public static int solve(int n,int[] heights)
    {
        if(n==0)
            return 0;
        
        if(dp[n] != -1)
            return dp[n];
        int jumpOne=Math.abs(heights[n] - heights[n-1]) + solve(n-1,heights);
        int jumpTwo=Integer.MAX_VALUE;
        if(n>1)
            jumpTwo = Math.abs(heights[n]-heights[n-2]) + solve(n-2,heights);
       
        dp[n]=Math.min(jumpOne,jumpTwo);
        return dp[n];
    }
//Top -down 
public class Solution {
    static int[] dp;
    public static int frogJump(int n, int heights[]) {
        dp= new int[n];
        dp[0]=0;
        
        for(int i=1; i<n; i++)
        {
            int right = Integer.MAX_VALUE;
            int left= Math.abs(heights[i] - heights[i-1]) + dp[i-1];
            if(i > 1)
                right= Math.abs(heights[i] - heights[i-2]) + dp[i-2];
            
            dp[i]= Math.min(left,right);
        }
        return dp[n-1];
    }
}
//More Optimization
public static int frogJump(int n, int heights[]) {
    int prev1=0,prev2=0,cur=0;
    for(int i=1; i<n; i++)
    {
        int right= Integer.MAX_VALUE;
        int left= Math.abs(heights[i] - heights[i-1]) + prev1;
        if(i > 1)
             right= Math.abs(heights[i] - heights[i-2]) + prev2;
        
        cur= Math.min(left,right);
        prev2= prev1;
        prev1=cur;
    }
    return prev1;
}
//TC-O(N) , SC-O(1)