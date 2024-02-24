public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;

        for(int i = 0 ; i < 32; i++)
        {
            int bit = (n >> i) & 1;
            if(bit != 0)
            {
                int num = 1 << (32 - i - 1);
                ans ^= num;
            }
        }
        return ans;
    }
}