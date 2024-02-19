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
        return solve(0, s,set);
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