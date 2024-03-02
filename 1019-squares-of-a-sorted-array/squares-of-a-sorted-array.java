class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        for(int i = 0 ; i < n; i++)
        {
            nums[i] *= nums[i]; 
        }
        int ans[] = new int[n];
        int left = 0, right = n -1;
        int index = n - 1;
        while(left <= right)
        {
            if(nums[left] > nums[right])
            {
                ans[index] = nums[left];
                left++;
            }else{
                ans[index] = nums[right];
                right--;
            }
            index--;
        }
        return ans;
    }
}