class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;

        for(int i: nums)
        {
            int res = k - i;

            if(map.containsKey(res))
            {
                count++;
                if(map.get(res) == 1)
                {
                    map.remove(res);
                }else{
                    map.put(res, map.get(res) - 1);
                }
            }
            else{
                map.put(i, map.getOrDefault(i,0) +1);
            }
        }
        return count;
    }
}