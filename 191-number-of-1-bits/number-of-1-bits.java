public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        for(int i = 0 ; i <= 32; i++)
        {
            int bit = n & 1;
            count += (bit == 1 ? 1 : 0);
            n >>>= 1;
        }
        return count;
    }
}