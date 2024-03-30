class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return getCount(nums, k ) - getCount(nums, k - 1); 
    }
    public int getCount(int nums[],int k)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;
        int ans = 0;
        for(int j = 0; j < nums.length; j++)
        {
            map.put(nums[j], map.getOrDefault(nums[j], 0 ) + 1);
            while(map.size() > k)
            {
                map.put(nums[i], map.get(nums[i]) - 1);
                if(map.get(nums[i]) == 0)
                {
                    map.remove(nums[i]);
                }
                i++;
            }
            ans += j - i + 1;
        }
        return ans;
    }
}