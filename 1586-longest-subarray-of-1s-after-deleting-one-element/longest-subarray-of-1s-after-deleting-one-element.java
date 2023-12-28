class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int lastIndex= -1;
        int i = 0;
        for(int j = 0 ; j < nums.length; j++)
        {
            if(nums[j] == 0)
            {
                i = lastIndex + 1;
                lastIndex = j;
            }

            max= Math.max(max, j - i); // window length aur ek element delete hoga for sure.
        }
        return max;
    }
    
}