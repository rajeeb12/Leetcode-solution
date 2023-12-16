class Solution {
    public boolean isAnagram(String s, String t) {
        int map[]= new int[128];

        for(char ch: s.toCharArray())
        {
            map[(int)ch]++;
        }
        for(char ch: t.toCharArray())
        {
            map[(int) ch]--;
        }

        for(int i = 0 ; i < 128; i++)
        {
            if(map[i] != 0) return false;
        }
        return true;

    }
}