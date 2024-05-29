class Solution {
    public int numSteps(String s) {
        int n = s.length();
        int carry = 0;
        int ans = 0;
        for(int i = n - 1; i >= 1; i--){
            if(s.charAt(i) - '0' + carry == 1){
                ans += 2;
                carry = 1;
            }
            else{
                ans++;
            }
        }
        return carry + ans;
    }
}