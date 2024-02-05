class Solution {
    int dp[][];
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        dp = new int[n1 + 1][n2 + 1];
        for(int i[]: dp)
        {
            Arrays.fill(i, - 1);
        }
        return solve(s1, s2,s1.length() - 1,s2.length() -1);
    }
    public int solve(String s1, String s2,int index1,int index2)
    {
        if(index1 < 0)
        {
            int total = 0;
            for(int p = 0 ; p <= index2; p++)
            {
                total += (int)s2.charAt(p);
            }
            return total;
        }
        if(index2 < 0)
        {
            int total = 0;
            for(int p = 0 ; p <= index1; p++)
            {
                total += (int)s1.charAt(p);
            }
            return total;
        }
        if(dp[index1][index2] != -1) return dp[index1][index2];

        int notsame = (int)1e9;
        if(s1.charAt(index1) == s2.charAt(index2))
        {
            return solve(s1,s2,index1 - 1, index2 - 1); 
        }
        else{
            notsame = Math.min(s1.charAt(index1) + solve(s1,s2,index1 - 1, index2) , s2.charAt(index2) + solve(s1, s2, index1, index2 - 1));
        }
        return dp[index1][index2]= notsame;
    }
}