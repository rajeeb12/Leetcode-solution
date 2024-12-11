class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int max = 0;
        for(int i = 0; i < n; i++){
            int x = nums[i] + (2 * k);
            int index = solve(nums, x);

            max = Math.max(max, index - i + 1);
        }
        return max;
    }
    public int solve(int nums[],int x){
        int i = 0, j = nums.length - 1;
        int ans = 0;
        while(i <= j){
            int mid = (i + j) >> 1;
            if(nums[mid] <= x){
                ans = mid;
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        return ans;
    }
}