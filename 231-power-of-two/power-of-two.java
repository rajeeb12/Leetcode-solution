class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 1) return true;
        if(n < 0) return false;

        int bitcount = Integer.bitCount(n);
        return (bitcount == 1);
    }
}