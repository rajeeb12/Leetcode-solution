class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        return countSubarray(nums, k) ; 
    }
    public int countSubarray(int nums[],int k)
    {
        int j = 0, prod = 1, n = nums.length;
        int max = 0;
        for(int i = 0 ; i < n; i++)
        {
            prod *= nums[i]; 
            while(j <= i && prod >= k)
            {
                prod /= nums[j];
                j++;
            }
            max += 1 + (i - j);   
        }
        return max;
    }
}