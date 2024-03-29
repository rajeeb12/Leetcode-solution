class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = 0;
        for(int i : nums)
        {
            maxElement = Math.max(maxElement, i);
        }
        long ans = 0;
        int l = 0, r = 0, n = nums.length;
        while(r < n)
        {
            k -= nums[r] == maxElement ? 1 : 0;
            while(k == 0)
            {
                k += nums[l] == maxElement ? 1 : 0;
                l++;
            }
            ans += l;
            r++;
        }
        return ans;
    }
}