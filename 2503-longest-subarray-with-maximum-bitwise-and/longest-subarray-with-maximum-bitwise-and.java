class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for(int i: nums){
            max = Math.max(i, max);
        }
        int ans = 0;
        int count = 0;
        for(int i: nums)
        {
            if(max == i)
            {
                count++;
            }else{
                ans = Math.max(ans, count);
                count = 0;
            }
        }
        ans = Math.max(ans, count);
        return ans;
    }
}