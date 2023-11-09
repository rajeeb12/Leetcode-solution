class Solution {
    public int countHomogenous(String s) {
        int mod = (int)1e9 + 7;
        int length = 0;
        int n = s.length();
        int result = 0; 
        // dry run abbcccaa using codewithmike approach

        for(int i = 0 ;  i < n; i++){
            if(i > 0 && s.charAt(i) == s.charAt(i-1)){
                length++;
            }else{
                length = 1;
            }
            result = (result + length) % mod;
        }
        return (result % mod);
    }
}