class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i: nums)
        {
            low = Math.max(low, i);
            high += i; 
        }
        int ans = 0;
        while(low <= high)
        {
            int mid = (low + high) >> 1;
            if(check(nums,mid,k))
            {
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean check(int[] nums,int maxSum,int k)
    {
        int curSum = 0;
        int count = 1;
        for(int i: nums)
        {
            if(curSum + i <= maxSum)
            {
                curSum += i;
            }else{
                count++;
                curSum = i;
            }
        }
        return (count <= k);
    }
}