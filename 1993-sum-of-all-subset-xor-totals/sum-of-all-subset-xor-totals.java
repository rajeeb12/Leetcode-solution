class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int ans[] = new int[1];
        solve(n - 1, nums, 0, ans);
        return ans[0];
    }
    public void solve(int index,int[] nums,int xor, int ans[]){
        if(index < 0){
            ans[0] += xor;
            return;
        }

        solve(index - 1, nums, xor ^ nums[index], ans);
        solve(index - 1, nums, xor, ans);

    }
}