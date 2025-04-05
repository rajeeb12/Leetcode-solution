class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        return solve(n - 1, nums, 0);
    }
    public int solve(int index,int[] nums,int xor){
        if(index < 0){
            return xor;
        }

        int pick = solve(index - 1, nums, xor ^ nums[index]);
        int skip = solve(index - 1, nums, xor);

        return pick + skip;
    }
}