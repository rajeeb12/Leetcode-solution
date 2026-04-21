class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        int map1[] = new int[26];
        int map2[] = new int[26];
        for(char c: word1.toCharArray()){
            map1[c-'a']++;
        }
        for(char c: word2.toCharArray()){
            map2[c-'a']++;
        }

        int occurence[] = new int[word2.length() + 1];
        for(int i = 0 ; i < 26; i++){
            if(map2[i] != 0 && map1[i] == 0) return false;
        }
        for(int i = 0; i < 26; i++){
            if(map1[i] != 0) occurence[map1[i]]++;
            if(map2[i] != 0) occurence[map2[i]]--;
        }
        for(int i: occurence) if(i != 0) return false;
        return true;
    }
}