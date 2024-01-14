class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        int map1[] = new int[27];
        int map2[] = new int[27];

        for(char ch : word1.toCharArray()){
            map1[ch-'a']++;
        }
        for(char ch : word2.toCharArray()){
            map2[ch-'a']++;
        }

        for(int i = 0 ; i < 27; i++)
        {
            if(map1[i] == 0 && map2[i] == 0) continue;
            if(map1[i] != 0 && map2[i] != 0) continue;// dono mein hai vo character so we can still swap and get the string

            return false;
        }

        Arrays.sort(map1);
        Arrays.sort(map2);

        for(int i = 0 ; i < 27; i++)
        {
            if(map1[i] != map2[i]) return false;
        }
        return true;
    } 
}