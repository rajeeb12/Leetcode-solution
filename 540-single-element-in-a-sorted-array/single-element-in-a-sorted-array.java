class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int lo = 0, hi = n - 1; 
        if(n == 1) return nums[0];

        if(nums[0] != nums[1])
        {
            return nums[0];
        }
        if(nums[n - 1] != nums[n - 2])
        {
            return nums[n - 1];
        }

        while(lo <= hi)
        {
            int mid = (lo + hi) >> 1;

            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
            {
                return nums[mid];
            }
            if(nums[mid] == nums[mid - 1])
            {
                if(mid % 2 == 0)
                {
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }else{
                if(mid % 2 != 0)
                {
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }
        }
        return  n;
    }
}