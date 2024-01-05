class Solution {
    public int numberOfSubstrings(String s) {
        if(s.length() < 3) return 0;
        return solve(s,3) - solve(s,2);
    }
    public int solve(String s,int max)
    {
        int map[]= new int[27];
        int i = 0;
        int ans = 0;
        for(int j =0; j < s.length(); j++)
        {
            map[s.charAt(j) - 'a']++;
            
            int count = 0;
            for(int k = 0 ; k < 27; k++)
            {
                if(map[k] != 0) count++;
            }

            while(i <= j && count > max)
            {
                map[s.charAt(i)-'a']--;
                count = 0;
                for(int k = 0 ; k < 27; k++)
                {
                    if(map[k] != 0) count++;
                }
                i++;
                if(count <= max) break;
            }

            ans += (j - i + 1);
        }
        return ans;
    }
}