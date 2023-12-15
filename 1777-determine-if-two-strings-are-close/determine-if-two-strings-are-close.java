class Solution {
    public boolean closeStrings(String word1, String word2) {
        int map1[]= new int[26];
        int map2[]= new int[26];

        if(word1.length() != word2.length()) return false;

        for(char ch: word1.toCharArray())
        {
            map1[ch-'a']++;
        }
        for(char ch: word2.toCharArray())
        {
            map2[ch-'a']++;
        }
        // option - 1
        for(int i = 0 ; i < 26; i++)
        {
            if(map1[i] != 0 && map2[i] !=0) continue; // word1 aur word2 dono mein smae cahracter hai
            if(map1[i] == 0 && map2[i] ==0) continue; // jo word1 mein nahi hai vo word2 mein bhi nahi hai

            return false;
        }
        Arrays.sort(map1);
        Arrays.sort(map2);

        for(int i =0 ; i < 26 ; i++)
        {
            if(map1[i] != map2[i]) return false;
        }
        return true;
    }
}