class Solution {
    public boolean isAnagram(String s, String t) {
        int count[] = new int[27];
        for(char ch: s.toCharArray()){
            count[ch-'a']++;
        }
        for(char ch: t.toCharArray()){
            count[ch-'a']--;
        }
        for(int i: count){
            if(i != 0) return false;
        }
        return true;

    }
}