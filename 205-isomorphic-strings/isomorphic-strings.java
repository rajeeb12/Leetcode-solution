class Solution {
    public boolean isIsomorphic(String s, String t) {
        int maps[]= new int[128];
        int mapt[]= new int[128];
        
        if(s.length() != t.length()) return false;

        for(int i = 0; i < s.length(); i++){
            int ch1 =(int) s.charAt(i);
            int ch2 =(int) t.charAt(i);

            if(maps[ch1] != mapt[ch2]) return false;

            maps[ch1] = i + 1;
            mapt[ch2] = i + 1;
        }
        return true;
    }
}