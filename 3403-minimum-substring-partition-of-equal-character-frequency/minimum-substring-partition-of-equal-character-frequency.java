class Solution {
    int dp[];
    public int minimumSubstringsInPartition(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(0,s);
    }
    public int solve(int index,String s){
        if(index == s.length())
        {
            return 0;
        }
        if(dp[index] != -1) return dp[index];
        
        int map[] = new int[26];
        int ans = (int)1e9;
        for(int i = index; i < s.length(); i++)
        {
            map[s.charAt(i) - 'a']++;
            String substr = s.substring(index, i + 1);
            if(isvalid(substr, map)){
                int temp = 1 + solve(i + 1, s);
                ans = Math.min(ans, temp);
            }
        }
        return dp[index] = ans;
    }
    public boolean isvalid(String s,int[] map)
    {
        int min = (int)1e9;
        int max = 0;
        for(int i = 0 ; i < 26; i++)
        {
            if(map[i] > 0){
                min = Math.min(min, map[i]);
                max = Math.max(max, map[i]);
            }
        }
        return min == max;
    }
}