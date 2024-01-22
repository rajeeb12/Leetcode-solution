class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: nums)
        {
            map.put(i, map.getOrDefault(i, 0 ) + 1);
        }
        int missing = 0;
        int repeated = 0;
        for(int i = 1 ; i <= n ; i++)
        {
            if(map.containsKey(i) && map.get(i) == 2) repeated = i;
            if(!map.containsKey(i)) missing = i; 
        }
        return new int[]{repeated, missing};
    }
}