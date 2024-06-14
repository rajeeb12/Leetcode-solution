class Solution {
    public int minPairSum(int[] nums) {
        int max = 0;
        Arrays.sort(nums);
        int n = nums.length;
        int j = n - 1; 
        for(int i = 0; i < n / 2; i++){
            int sum = nums[i] + nums[j];
            max = Math.max(sum , max);
            j--;
        }
        return max;
    }
}