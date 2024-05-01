class Solution {
    int dp[][];
    public int findRotateSteps(String ring, String key) {
        dp = new int[ring.length() + 1][key.length() + 1];
        for(int i[] : dp)
        {
            Arrays.fill(i,-1);
        }
        return solve(0,0,ring,key);
    }
    public int solve(int indexk,int indexr,String ring,String key)
    {
        if(indexk == key.length()) return 0;
        
        if(dp[indexr][indexk] != -1) return dp[indexr][indexk];
        int ans = (int)1e9;

        for(int i = 0; i < ring.length(); i++)
        {
            if(ring.charAt(i) == key.charAt(indexk))
            {
                int antic = Math.abs(i - indexr);
                int clock = Math.abs(ring.length() - antic);
                int minans = Math.min(antic , clock);

                minans += 1 + solve(indexk + 1,i,ring,key);
                ans = Math.min(ans, minans);
            }
        }
        return dp[indexr][indexk] = ans;
    }
}