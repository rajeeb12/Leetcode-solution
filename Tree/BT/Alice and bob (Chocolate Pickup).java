//Recursive + memo
public class Solution {
    static int dp[][][];
	public static int maximumChocolates(int r, int c, int[][] grid) {
        dp=new int[r][c][c];
        for(int row[][] : dp)
        {
            for(int col[]: row)
            {
                Arrays.fill(col,-1);
            }
        }
        return solve(0,0,c-1,grid,r,c);
	}
    public static int solve(int i,int j1,int j2, int[][] grid,int r,int c)
    {
        if(j1<0 || j2<0 || j1>=c || j2>=c)
            return (int)Math.pow(-10,9);
        
        if(i==r-1)//BC
        {
            if(j1==j2)
            {
                return grid[i][j1];
            }
            else
            {
                return grid[i][j1] + grid[i][j2];
            }
        }
        
        if(dp[i][j1][j2] != -1)
            return dp[i][j1][j2];
        
        int max=0;
        for(int dj1=-1 ; dj1<=1; dj1++) // 9states
        {
            for(int dj2=-1; dj2<=1; dj2++)
            {
                if(j1==j2)
                {
                    max= Math.max(max,grid[i][j1] + solve(i+1, j1 + dj1, j2 + dj2, grid , r, c));
                }
                else
                {
                    max= Math.max(max, grid[i][j1] + grid[i][j2] + solve(i+1, j1 + dj1, j2 + dj2, grid , r, c));
                }
            }
        }
        dp[i][j1][j2]=max;
        return dp[i][j1][j2];
    }
}