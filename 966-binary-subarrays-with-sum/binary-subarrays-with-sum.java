class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;
        map.put(0,1);
        for(int i: nums)
        {
            sum += i;
            if(map.containsKey(sum - goal))
            {
                ans += map.get(sum - goal);
            }
            map.put(sum, map.getOrDefault(sum , 0 ) + 1);
        }
        return ans;
    }
}