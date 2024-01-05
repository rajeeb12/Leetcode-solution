class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return getCountOfSubarrayWithK(nums, k) - getCountOfSubarrayWithK(nums, k - 1);
    }
    public int getCountOfSubarrayWithK(int[] nums,int k)
    {
        int count = 0;
        int res = 0;
        int i=0;
        for(int j = 0 ; j < nums.length; j++)
        {
            if(nums[j] % 2 != 0)
            {
                count++;
            }

            while(count > k)
            {
                if(nums[i] % 2 != 0)
                {
                    count--;
                }
                i++;
            }

            res +=  (j - i + 1);
        }
        return res;
    }
}