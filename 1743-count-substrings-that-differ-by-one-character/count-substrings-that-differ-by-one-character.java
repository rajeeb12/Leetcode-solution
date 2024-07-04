class Solution {
    public int countSubstrings(String s, String t) {
        int n = s.length();
        int m = t.length();
        int ans = 0; 
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                String substr = s.substring(i, j + 1);

                ans += check(substr, t);
            }
        }
        return ans;
    }
    public int check(String s,String t)
    {
        int total = 0;
        int n = s.length();
        int m = t.length();
        for(int i = 0; i < m - n + 1; i++)
        {
            int count = 0;    
            for(int j = 0; j < s.length(); j++)
            {
                if(s.charAt(j) == t.charAt(i + j))
                {
                    count++;
                }
            }
            if(s.length() - count == 1) total++;
        }
        return total;
    }
}