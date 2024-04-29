class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = 0;
        for(int i : nums){
            xor ^= i;
        }
        int count = 0;
        for(int i = 0; i < 32; i++)
        {
            int bitOfXor = (xor >> i) & 1;
            int bitOfk = (k >> i) & 1;

            if(bitOfXor != bitOfk) count++;
        }
        return count;
    }
}