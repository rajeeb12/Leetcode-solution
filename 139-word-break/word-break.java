class Solution {
    Boolean dp[];
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        dp = new Boolean[n + 1];
        HashSet<String> set = new HashSet<>();
        for(String str: wordDict)
        {
            set.add(str);
        }

        dp[n] = true;
        
        for(int index = n - 1; index >= 0; index--)
        {
            boolean flag = false;
            for(int i = index; i < s.length(); i++)
            {
                if(set.contains(s.substring(index, i + 1)) && dp[i + 1])
                {
                    dp[index]= true;
                    flag = true;
                }
            }
            if(!flag)
            {
                dp[index] = flag;
            }
        }
        return dp[0];
        //return solve(0, s,set);
    }
    public boolean solve(int index,String s, HashSet<String> set)
    {
        if(index == s.length())
        {
            return true;
        }
        if(dp[index] != null) return dp[index];

        for(int i = index; i < s.length(); i++)
        {
            if(set.contains(s.substring(index, i + 1)) && solve(i + 1, s, set))
            {
                return dp[index]= true;
            }
        }
        return dp[index] = false;
    }
}