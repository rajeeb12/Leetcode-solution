class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int lo = 0 , hi = nums.length - 1;
        int ans = (int)1e9;
        while(lo <= hi)
        {
            int mid = (lo +hi) >> 1;
            if(nums[lo] <= nums[hi])
            {
                ans = Math.min(ans, nums[lo]);
                break;
            }
            if(nums[lo] <= nums[mid])
            {
                ans = Math.min(ans, nums[lo]);
                lo = mid + 1;
            }
            else{
                ans = Math.min(ans, nums[mid]);
                hi = mid - 1;
            }
        }
        return ans;
    }
}