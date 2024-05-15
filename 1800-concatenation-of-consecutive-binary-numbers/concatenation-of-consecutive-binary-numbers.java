class Solution {
    public int concatenatedBinary(int n) {
        if(n == 1) return 1;
        long ans = 1;
        int mod = (int)1e9 + 7;

        for(int i = 2; i <= n; i++)
        {
            ans = ((ans << (Integer.toBinaryString(i).length()) % mod ) + i ) % mod;
        }
        return (int) ans;
    }
    
}