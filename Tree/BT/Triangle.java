//Recurrence + memo
import java.util.* ;
import java.io.*; 
public class Solution {
    static int dp[][];
    public static int minimumPathSum(int[][] triangle, int n) {
        dp= new int[n][n];
        for(int row[]: dp)
        {
            Arrays.fill(row,-1);
        }
        return solve(0,0,triangle,n);
    }
    public static int solve(int i,int j,int[][] triangle,int n)
    {
        if(i==n-1)
            return triangle[i][j];
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int d= triangle[i][j] + solve(i+1, j, triangle, n);
        int dg= triangle[i][j] + solve(i+1, j+1, triangle, n);
        
        dp[i][j]=Math.min(d,dg);
        return dp[i][j];
    }
}
// Tabulation
public static int minimumPathSum(int[][] triangle, int n) {
    int dp[][]= new int[n][n];
    
    for(int i=0; i<n; i++)
    {
        dp[n-1][i]= triangle[n-1][i];
    }
    for(int i=n-2 ; i>=0; i--)
    {
        for(int j=i ; j>=0; j--)
        {
            int d= triangle[i][j] + dp[i+1][j];
            int dg= triangle[i][j] + dp[i+1][j+1];
            dp[i][j]= Math.min(d,dg);
        }
    }
    return dp[0][0];
}