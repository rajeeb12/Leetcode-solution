class Solution {
    public int[] sortedSquares(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        int n = nums.length;
        int left = 0, right = n-1;
        int ans[] = new int[n];

        for(int i = n - 1; i >= 0 ; i--)
        {
            if(Math.abs(nums[right]) > Math.abs(nums[left])) // right && left convertig to +ve then checking 
            {
                ans[i] = nums[right] * nums[right];
                right--;
            }else{
                ans[i] = nums[left] * nums[left];
                left++;
            }
        } 
        return ans;
    }
}