class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 2;
    
        int n = nums.length;
        if(n == 0) return  0;

        int count = 1;
        int m = 1;

        for(int i = 1; i < n; i++)
        {
            if(nums[i] == nums[i - 1])
            {
                if(count < k)
                {
                    nums[m++] = nums[i];
                }
                count++;
            }else{
                count = 1;
                nums[m++] = nums[i];
            }
        }
        return m; 
    }
}