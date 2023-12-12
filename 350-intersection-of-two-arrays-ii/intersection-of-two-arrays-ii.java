class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();

        for(int i : nums1)
        {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }
        for(int i : nums2)
        {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: map1.entrySet()){
            int key = entry.getKey();
            if(map2.containsKey(key))
            {
                int minDuplicates =  Math.min(entry.getValue(), map2.get(key));

                for(int i = 0 ; i < minDuplicates; i++)
                {
                    ans.add(key);
                }
            }
        }
        int res[]= new int[ans.size()];
        for(int i = 0 ; i < ans.size() ; i++)
        {
            res[i] = ans.get(i);
        }
        return res;
    }
}