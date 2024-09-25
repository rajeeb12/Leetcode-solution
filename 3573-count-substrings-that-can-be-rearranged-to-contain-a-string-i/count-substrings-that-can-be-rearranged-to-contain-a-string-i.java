class Solution {
    public long validSubstringCount(String word1, String word2) {
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        long ans = 0;

        for(int i = 0; i < word2.length(); i++){
            freq2[word2.charAt(i)- 'a']++;
        }
        int i = 0;
        for(int j = 0; j < word1.length(); j++)
        {
            char c = word1.charAt(j);

            freq1[c-'a']++;
            boolean ok = true;

            for(int k = 0; k < 26; k++)
            {
                if(freq1[k] < freq2[k]){
                    ok = false;
                    break;
                }
            }

            if(ok)
            {
                
                while(i <= j)
                {
                    char lc = word1.charAt(i);
                    freq1[lc-'a']--;
                    if(freq1[lc-'a'] < freq2[lc-'a']){
                        freq1[lc-'a']++;
                        break;
                    }
                    i++;
                }
                ans += (i + 1);
            }
        }
        return ans;
    }
}