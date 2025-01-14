class Solution {
    public int minimumLength(String s) {
        int map[] = new int[26];

        for(char c: s.toCharArray()) map[c-'a']++;

        int ans = 0;
        for(int i = 0; i < 26; i++){
            while(map[i] >= 3){
                map[i] -= 2;
            }
            ans += map[i];
        }
        return ans;
    }
}