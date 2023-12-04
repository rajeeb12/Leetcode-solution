class Solution {
    public void moveZeroes(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        for(int i = 0 ; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                p1 = i;
                p2 = i+1; 
                break;
            }
        }
        while(p2 < nums.length)
        {
            if(nums[p2] != 0)
            {
                swap(nums,p2,p1);
                p1++;
            }
            p2++;
        }
    }
    public void swap(int[] nums,int left,int right)
    {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp; 
    }
}