class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length) return intersect(nums2, nums1);
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i : nums1)
        {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int item: nums2){
            if(map.containsKey(item) &&  map.get(item) > 0)
            {
                ans.add(item);
                map.put(item, map.get(item) - 1);
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