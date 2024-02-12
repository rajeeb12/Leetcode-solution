class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < 32 ; i++)
        {
            int cur = 0;
            for(int j = 0; j < n ; j++)
            {
                cur += (nums[j] >> i) & 1;
            }
            sum += cur*(n - cur);
        }
        return sum;
    }
}