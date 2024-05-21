public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        while(n != 0){
            int bit = n & ~(n - 1);
            if(bit == 1) count++;
            n = n >> 1;
        }
        return count;
    }
}