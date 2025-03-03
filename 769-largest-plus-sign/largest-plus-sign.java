class Solution {
    int dp[][][];
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int arr[][] = new int[n][n];
        dp = new int[n + 1][n + 1][4];

        for(int i[][]: dp){
            for(int j[]: i){
                Arrays.fill(j, -1);
            }
        }

        for(int i[]: arr){
            Arrays.fill(i, 1);
        }
        for(int i[]: mines){
            arr[i[0]][i[1]] = 0;
        }
        int largest = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 0) continue;
                
                int up = solve(i - 1,j,arr,n, 0);
                int down = solve(i + 1,j,arr,n, 1);
                int left = solve(i,j - 1,arr,n, 2);
                int right = solve(i,j + 1,arr,n, 3);
                
                int min = 1 + Math.min(up, Math.min(down, Math.min(left, right)));
                
                largest = Math.max(largest, min);
            }
        }
        return largest;
    }
    public int solve(int r,int c,int arr[][],int n,int dir){
        if(c == -1 || r == n  || r == -1 || c == n){
            return 0;
        }
        if(arr[r][c] == 0) return 0;

        if(dp[r][c][dir] != -1) return dp[r][c][dir];

        int up = 0, down = 0, left = 0, right = 0;
        switch (dir){
            case 0:
                up = arr[r][c] + solve(r - 1, c, arr, n, dir);
                break;
            case 1:
                down = arr[r][c] +  solve(r + 1, c, arr, n, dir);
                break;
            case 2: 
                left = arr[r][c] + solve(r, c - 1, arr, n, dir);
                break;
            case 3:
                right = arr[r][c] + solve(r, c + 1, arr, n, dir);
                break;
        }
        

        if(dir == 0){
            dp[r][c][0] = up;
            return dp[r][c][0];
        }
        else if(dir == 1){
            dp[r][c][1] = down;
            return dp[r][c][1];
        }
        else if(dir == 2){
            dp[r][c][2] = left;
            return dp[r][c][2];
        }
        dp[r][c][3] = right;
        return dp[r][c][3];
    }
}