class Solution {
    public int maxOperations(String s) {
        int ones = 0, ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                ones++;
            }
            if(s.charAt(i) == '0' && (i + 1 == s.length() || s.charAt(i + 1) == '1')){
                ans += ones; 
            }
        }
        return ans;
    }
}