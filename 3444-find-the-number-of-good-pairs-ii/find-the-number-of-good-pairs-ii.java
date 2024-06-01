class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: nums2)
        {
            map.put(i * k, map.getOrDefault(i*k, 0) + 1);
        }
        int n = nums1.length; 
        for(int i = 0; i < n; i++)
        {
            for(int j = 1; j * j <= nums1[i]; j++)
            {
                if(nums1[i] % j == 0){
                    
                    if(map.containsKey(j)){
                        ans += map.get(j);
                    }
                    int val = nums1[i] / j;
                    if(j != val && map.containsKey(val)){
                        ans += map.get(val);
                    }
                }
            }
        }
        return ans;
    }
}