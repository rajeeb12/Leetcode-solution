class Solution {
    public int threeSumClosest(int[] nums, int target) {
      Arrays.sort(nums);
        int smallestDiff = (int)1e9;
        int ans = 0;
        int n = nums.length;
        for(int i = 0 ; i < n - 2; i++)
        {
            int j = i + 1 , k = n-1;
            int sum = 0;
            while(j < k)
            {
                sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);
                if(diff  < smallestDiff)
                {
                    ans = sum;
                    smallestDiff = diff;
                }
                if(sum == target) return sum;
                if(sum > target)
                {
                  k--;
                }else{
                  j++;
                }
            }
        }
        return ans;
    }
}