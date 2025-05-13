class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int count[] = new int[26];
        int mod = (int)1e9 + 7;

        for(char c: s.toCharArray()) count[c-'a']++;

        while(t-- > 0){
            int temp[] = new int[26];

            for(int i = 0; i < 26; i++){
                if(i == 25 && count[i] > 0){
                    temp[0] = (temp[0] + count[i]) % mod;
                    temp[1] = (temp[1] + count[i]) % mod;
                }else{
                    if(count[i] > 0){
                        temp[i + 1] = (temp[i + 1] + count[i]) % mod;
                    }
                }
            }
            for(int i = 0; i < 26; i++) count[i] = temp[i];
        }
        int ans = 0;
        for(int c: count) ans = (ans + c) % mod;
        return ans;
    }
}