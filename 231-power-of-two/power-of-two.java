class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 1) return true;
        if(n < 0) return false;

        int bitcount = getCount(n);
        return (bitcount == 1);
    }
    public int getCount(int n)
    {
        int count = 0;

        while(n != 0)
        {
            count += (n & 1);
            n >>>= 1;
        }
        return count;
    }
}