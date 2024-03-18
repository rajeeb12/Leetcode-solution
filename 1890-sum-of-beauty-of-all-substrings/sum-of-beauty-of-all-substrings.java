class Solution {
    public int beautySum(String s) {
        int ans = 0;
        int n = s.length();
        for(int i = 0 ; i < n; i++)
        {
            int map[] = new int[26];
            for(int j = i; j < n; j++)
            {
                map[s.charAt(j) - 'a']++;
                int max = -1;
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < 26; k++)
                {
                    if(map[k] != 0)
                    {
                        max = Math.max(max, map[k]);
                        min = Math.min(min, map[k]);
                    }
                }
                if(max != -1 && min != Integer.MAX_VALUE)
                {
                    ans += max - min;
                }
            }
        }
        return ans;
    }
}