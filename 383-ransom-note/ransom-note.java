class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length() < ransomNote.length()) return false;
        int map[] = new int[26];
        for(char c: magazine.toCharArray()){
            map[c - 'a']++;
        }
        for(char c: ransomNote.toCharArray()){
            if(map[c-'a'] == 0) return false;
            map[c-'a']--;
        }
        return true;
    }
}