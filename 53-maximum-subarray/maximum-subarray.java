class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;

        for(int i  = 0; i < n; i++){
            if(sum < 0){
                sum = 0;
            }

            sum += nums[i];
            max = Math.max(max , sum);
        }
        return max;
    }
}