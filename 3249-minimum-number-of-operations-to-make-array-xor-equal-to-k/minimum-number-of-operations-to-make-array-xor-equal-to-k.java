class Solution {
    public int minOperations(int[] nums, int k) {
        int res = 0;
        for(int i: nums)
        {
            res ^= i;
        }

        return getCount(res, k);
    }
    public int getCount(int res, int k)
    {
        int count = 0;
        for(int i = 0 ; i < 32 ; i++)
        {
            int bitOfres = res & (1 << i);
            int bitOfk = k & (1 << i);

            if(bitOfres != bitOfk) count++ ;
        }
        return count;
    }
}