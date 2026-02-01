class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        if(n == 3){
            return nums[0] + nums[1] + nums[2];
        }
        int min = (int)1e9;
        for(int i = 1; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                min = Math.min(min, nums[0] + nums[i] + nums[j]);
            }
        }
        return min;
    }
}