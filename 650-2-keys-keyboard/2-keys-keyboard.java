class Solution {
    int dp[][];
    public int minSteps(int n) {
        if(n == 1) return 0;
        dp = new int[1001][1001];
        
        for(int i[]: dp) Arrays.fill(i, -1);

        return solve(1, 1,n) + 1;
    }
    public int solve(int board,int clipboard,int n)
    {
        if(board > n) return (int)1e9;
        if(board == n){
            return 0;
        }
        if(dp[board][clipboard] != -1) return dp[board][clipboard];
        
        int copy = 1 + 1 + solve(board + board, board, n);
        int paste = 1 + solve(board + clipboard, clipboard, n);

        return dp[board][clipboard] = Math.min(copy , paste); 
    }
    
}