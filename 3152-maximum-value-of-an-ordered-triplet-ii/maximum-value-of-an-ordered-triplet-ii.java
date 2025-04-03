class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];
        leftMax[0] = nums[0];
        rightMax[n - 1] = nums[n - 1];

        for(int i = 1; i < n - 1; i++){
            leftMax[i] = Math.max(nums[i - 1], leftMax[i - 1]);
            rightMax[n - i - 1] = Math.max(nums[n - i], rightMax[n - i]);
        }
        long ans = 0;
        for(int j = 1; j < n - 1; j++){
            long cal = (leftMax[j] - nums[j]);
            long mul = cal * rightMax[j]; 
            ans = Math.max(ans, mul);
        }
        return ans;
    }
}