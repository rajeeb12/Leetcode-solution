class Solution {
    public long findMaximumScore(List<Integer> nums) {
        int p = 0;
        long ans = 0;
        int n = nums.size();
        for(int i = 1; i < n; i++)
        {
            if(nums.get(p) <= nums.get(i))
            {
                ans += (long) ((i - p) * 1L * nums.get(p));
                p = i;
            }else if(i == n - 1)
            {
                ans += (long) ((i - p) * 1L * nums.get(p));
            }
        }
        return ans;
    }
}