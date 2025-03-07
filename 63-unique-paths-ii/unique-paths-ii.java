class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int dp[][] = new int[n + 1][m + 1];

        for(int i = 0; i < n ; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(arr[i][j] == 1){
                    dp[i][j] = 0;
                }
                else if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }else{
                    int up = 0, left = 0;

                    if(j > 0)left += dp[i][j - 1];
                    if(i > 0)up += dp[i - 1][j];
                    dp[i][j] = left + up;
                }
            }
        }
        return dp[n - 1][m - 1];
        //return solve(n - 1, m - 1, og);
    }
    public int solve(int i,int j,int arr[][]){
        if(i >= 0 && j >= 0 && arr[i][j] == 1) return 0;

        if(i < 0 || j < 0) return 0;

        if(i == 0 && j == 0) return 1;
        
        int up = 0, left = 0;

        left += solve(i, j - 1, arr);
        up += solve(i - 1, j ,arr);

        return up + left;
    }
}