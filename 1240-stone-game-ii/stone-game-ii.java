class Solution {
    int dp[][][];
    public int stoneGameII(int[] piles) 
    {
        int n = piles.length;
        dp = new int[101][2][101];
        for(int i[][] : dp){
            for(int j[]: i){
                Arrays.fill(j, - 1);
            }
        }
        return solve(0, 1, 1, piles);
    }
    public int solve(int index,int person,int m,int piles[]){
        if(index >= piles.length) return 0;
        
        if(dp[index][person][m] != -1) return dp[index][person][m];

        int temp = (person == 1 ? 0 : (int)1e9);
        int n = piles.length;
        int stones = 0 , count = 0;
        for(int i = 1; i <= Math.min(2* m, n - index) ; i++)
        {
            stones += piles[index + i - 1];
            if(person == 1)
            {
                temp = Math.max(temp, stones + solve(index + i, 0, Math.max(i, m), piles));
            }else{
                temp = Math.min(temp, solve(index + i, 1, Math.max(i, m), piles));
            }
        }
        return dp[index][person][m] = temp;
    }
}