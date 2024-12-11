class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int i = 0, max = 0;
        for(int j = 0; j < n; j++){
            if(nums[j] > nums[i] + (2 * k)){
                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
    
}