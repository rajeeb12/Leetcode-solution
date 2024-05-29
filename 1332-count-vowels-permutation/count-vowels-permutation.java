class Solution {
    long dp[][];
    int mod;
    public int countVowelPermutation(int n) {
        mod = (int)1e9 + 7;
        dp = new long[n + 1][26];

        for(long i[]: dp) Arrays.fill(i, -1);

        long ans = 0;
        ans = (ans + solve(n - 1,'a')) % mod;
        ans = (ans + solve(n - 1,'e')) % mod;
        ans = (ans + solve(n - 1,'i')) % mod;
        ans = (ans + solve(n - 1,'o')) % mod;
        ans = (ans + solve(n - 1,'u')) % mod; 
        return (int) ans % mod;
    }
    public long solve(int n,char c){
        if(n == 0) return 1;

        if(dp[n][c-'a'] != -1) return dp[n][c-'a'];
        
        if(c == 'a'){
            dp[n][c-'a'] = solve(n - 1, 'e') % mod;
        }
        else if(c == 'e'){
            dp[n][c-'a'] = (solve(n - 1, 'a') + solve(n - 1, 'i')) % mod;
        }
        else if(c == 'i'){
            dp[n][c-'a'] = (solve(n - 1, 'a') + solve(n - 1, 'e') + solve(n - 1, 'o') + solve(n - 1, 'u')) % mod;
        }
        else if(c == 'o'){
            dp[n][c-'a'] = (solve(n - 1, 'i') + solve(n - 1, 'u')) % mod;
        }else{
            dp[n][c-'a'] = solve(n - 1, 'a') % mod;
        }
        return dp[n][c-'a'];
    }
    
}