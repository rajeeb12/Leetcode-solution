class Solution {
    public int concatenatedBinary(int n) {
        if(n == 1) return 1;
        long ans = 1;
        int mod = (int)1e9 + 7;

        for(int i = 2; i <= n; i++)
        {
            int len = (int) (Math.floor( Math.log(i) / Math.log(2)) + 1 );
            ans = ((ans << (len) % mod ) + i ) % mod;
        }
        return (int) ans;
    }
    
}