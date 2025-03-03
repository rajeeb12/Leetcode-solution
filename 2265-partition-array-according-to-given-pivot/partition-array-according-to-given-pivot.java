class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int ans[] = new int[n];
        int index = 0;
        Arrays.fill(ans, (int)1e7);
        for(int i = 0; i < n; i++){
            if(nums[i] < pivot){
                ans[index++] = nums[i];
            }
        }
        index = n - 1;
        for(int i = n - 1; i >= 0; i--){
            if(nums[i] > pivot){
                ans[index--] = nums[i];
            }
        }
        for(int i = 0; i < n; i++){
            if(ans[i] != (int)1e7) continue;
            ans[i] = pivot;
        }
        return ans;
    }
}