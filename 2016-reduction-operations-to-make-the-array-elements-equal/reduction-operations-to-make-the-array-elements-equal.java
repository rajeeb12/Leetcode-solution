class Solution {
    public int reductionOperations(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        Arrays.sort(nums);

        int index = n - 1;
        int count = 0;
        for(index  = n - 1; index >= 0; index--){
            if(index == n-1 || nums[index] == nums[index + 1]) continue;
            if(nums[index] < nums[index + 1]){
                count += (n - 1 - index);
            }
        }
        return count;
    }
}