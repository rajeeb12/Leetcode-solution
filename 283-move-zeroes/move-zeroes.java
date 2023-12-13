class Solution {
    public void moveZeroes(int[] nums) {
        int p1 = -1;
        int n = nums.length;
        for(int i = 0 ; i < n; i++)
        {
            if(nums[i] == 0){
                p1 = i;
                break;
            }
        }
        if(p1 == -1) return;

        for(int i = p1 + 1; i < n ; i++)
        {
            if(nums[i] != 0)
            {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1++; 
            }
        }
    }
}