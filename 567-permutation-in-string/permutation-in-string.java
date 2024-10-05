class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int map[] = new int[26];
        for(char c: s1.toCharArray()) map[c-'a']++;
        
        int map2[] = new int[26];
        int i = 0;
        int n = s2.length();
        for(int j = 0; j < n; j++)
        {
            map2[s2.charAt(j) - 'a']++;
            int curSize = j - i + 1;
            if(curSize > s1.length())
            {
                map2[s2.charAt(i) - 'a']--;
                i++;
            }
            
            boolean flag = true;
            for(int k = 0; k < 26; k++)
            {
                if(map[k] != map2[k])
                {
                    // System.out.print(i +" "+j+" "+map[k]+"| ");
                    flag = false;
                    break;
                }
            }
            if(flag) return true;
        }
        return false;
    }
}