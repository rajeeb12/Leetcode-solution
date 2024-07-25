class Solution {
    public int minimumLength(String s) {
        int map[] = new int[26];

        for(char c: s.toCharArray()){
            map[c-'a']++;
            if(map[c-'a'] >= 3){
                map[c-'a'] = 1;
            }
        }
        int ans = 0;
        for(int i: map) ans += i;
        return ans;
    }
}