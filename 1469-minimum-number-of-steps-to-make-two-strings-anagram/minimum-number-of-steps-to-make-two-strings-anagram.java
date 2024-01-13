class Solution {
    public int minSteps(String s, String t) {
        int n = s.length();
        int map1[] = new int[26];
        int map2[] = new int[26];

        for(int i = 0 ; i < n ; i++)
        {
            map1[s.charAt(i) - 'a']++;
            map2[t.charAt(i) - 'a']++;
        }
        int count = 0;
        for(int i = 0 ; i < 26; i++)
        {
            if(map1[i] == 0) continue;
            if(map1[i] > map2[i])
            {
                count += (map1[i] - map2[i]);
            }
            
        }
        return count;
    }
}