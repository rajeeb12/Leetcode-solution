class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans= 0;
        int min = -1, max = -1, lastseen = -1, n = nums.length;

        for(int i = 0; i < n; i++)
        {
            if(nums[i] < minK || nums[i] > maxK) lastseen = i;
            if(nums[i] == minK) min = i;
            if(nums[i] == maxK) max = i;

            ans += Math.max(0L, Math.min(min,max) - lastseen); 
        }
        return ans;
    }
}