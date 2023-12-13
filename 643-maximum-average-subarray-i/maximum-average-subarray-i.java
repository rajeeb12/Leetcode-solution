class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = 0.0;
        double sum = 0.0;
        int left = 0, right = k;

        for(int i= 0 ; i < k ; i++)
        {
            sum += nums[i];
        }
        maxAvg = (double)sum / k;

        while(right < nums.length)
        {
            sum -= nums[left++];
            sum += nums[right++];

            maxAvg =(double)Math.max(maxAvg, (double) sum / k);
        }
        return maxAvg; 
    }
}