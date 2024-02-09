class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        int n = words.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, 1);

        int max = 1;
        for(int i = 0 ; i < n; i++)
        {
            for(int pi = 0; pi < i; pi++)
            {
                if(words[i].length() == words[pi].length() + 1)
                {
                    boolean ans = isSuccesor(words[i] , words[pi]);
                    System.out.println(ans);
                    if(ans && dp[i] < dp[pi] + 1)
                    {
                        dp[i] = dp[pi] + 1;
                        max = Math.max(max, dp[i]);
                    }
                }
            }
        }
        return max;
    }
    public boolean isSuccesor(String s1,String s2)
    {
        int first = 0;
        int second = 0;

        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }
        return (first == s1.length() && second == s2.length());
    } 
}