class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int dp[] = new int[26];
        int ans = 0;
        for(int i = 0; i < s.length(); i++)
        {
            int elem = s.charAt(i) - 'a';
            for(int j = elem; j >= 0 && j >= elem - k; j--){
                dp[elem] = Math.max(dp[elem] , dp[j] + 1);
            }
            for(int j = elem + 1; j < 26 && j <= elem + k; j++)
            {
                dp[elem] = Math.max(dp[elem] , dp[j] + 1);
            }
            ans = Math.max(dp[elem] , ans);
        }

        return ans;
    }
}