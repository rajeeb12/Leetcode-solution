class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int countZero= 0;
        int i = 0;
        for(int j = 0 ; j < nums.length; j++)
        {
            if(nums[j] == 0) countZero++;
            while(countZero > 1)
            {
                if(nums[i] == 0)
                {
                    countZero--;
                }
                i++;
            }

            max= Math.max(max, j - i); // window length aur ek element delete hoga for sure.
        }
        return max;
    }
    
}