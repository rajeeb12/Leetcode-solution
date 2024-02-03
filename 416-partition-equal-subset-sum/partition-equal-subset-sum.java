class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalsum = 0;
        for(int i: nums) totalsum += i;

        if(totalsum % 2 == 1) return false;

        totalsum /= 2;
        boolean prev[] = new boolean[totalsum + 1]; 

        prev[0] = true;
        if(nums[0] <= totalsum) prev[nums[0]] = true;

        for(int ind = 1; ind < n; ind++)
        {
            boolean cur[]= new boolean[totalsum + 1];
            cur[0] = true;
            for(int t = 1; t <= totalsum; t++)
            {
                boolean notTaken = prev[t];

                // Calculate if the current element is taken
                boolean taken = false;
                if (nums[ind] <= t) {
                    taken = prev[t - nums[ind]];
                }

                // Updae the DP table for the current element and target sum
                cur[t] = notTaken || taken;
            }
            prev = cur;
        }  
        return prev[totalsum];
    }
}