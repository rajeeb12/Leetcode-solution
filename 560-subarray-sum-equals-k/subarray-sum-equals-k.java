class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for(int i = 0 ; i < n; i++)
        {
            sum += nums[i];
            int rem = sum - k; 
            if(map.containsKey(rem))
            {
                ans += map.get(rem);
            }
            map.put(sum , map.getOrDefault(sum , 0) + 1);
        }
        return ans;
    }
}