class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        int sum = 0;
        int i = 0;

        for(int j = 0; j < nums.length; j++){
            sum += nums[j];
            if(j - i + 1 == k){
                double cal = (sum * 1.0) /  k;
                max = (double) Math.max(max, cal);
                sum -= nums[i];
                i++;
            }
        }
        return max;
    }
}