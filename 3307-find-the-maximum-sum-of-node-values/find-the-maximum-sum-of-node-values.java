class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long totalSum = 0;

        for(int i : nums)
        {
            totalSum += (long) i;
        }
        int  n = nums.length;
        int count = 0;
        long idealSum = 0;
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++)
        {
            int diff = (nums[i] ^ k) - nums[i];

            if(diff > 0){
                idealSum += (long) (nums[i] ^ k);
                count++;
            }else{
                idealSum += (long) nums[i];
            }
            minDiff = Math.min(minDiff, Math.abs(diff));
        }
        if(count % 2 == 0) return idealSum;

        return idealSum - (long)minDiff;
    }
}