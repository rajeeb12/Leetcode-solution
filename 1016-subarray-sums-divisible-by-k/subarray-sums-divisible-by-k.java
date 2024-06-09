class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        map.put(0, 1);
        for(int i : nums){
            sum += i;
            int remainder = sum % k;
            if(remainder < 0) remainder += k;
            
            if(map.containsKey(remainder))
            {
                ans += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder , 0 ) + 1);
        }
        return ans;
    }
}