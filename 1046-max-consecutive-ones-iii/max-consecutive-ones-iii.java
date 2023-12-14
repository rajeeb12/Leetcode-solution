class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, cz = 0, max = 0, count = 0;

        for(right = 0 ; right < nums.length; right++)
        {
            if(nums[right] == 0)
            {
                cz++;
            }
            if(cz > k)
            {
                while(cz > k)
                {
                    if(nums[left] == 0) cz--;
                    count--;
                    left++;
                }
            }
            count++;
            max = Math.max(max, count);
        }
        return max;
    }
}