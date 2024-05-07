class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int ans[] = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();

        for(int i = 0; i < n; i++)
        {
            if(rains[i] == 0)
            {
                set.add(i);
                ans[i] = 1;
            }else{
                Integer occurBefore = map.get(rains[i]);
                if(occurBefore == null){
                    map.put(rains[i], i);
                }else{
                    Integer dry = set.higher(occurBefore);
                    if(dry == null) return new int[]{};
                    ans[dry] = rains[i];
                    set.remove(dry);
                    map.put(rains[i] ,i);
                }
                ans[i] = -1;
            }
        }
        return ans;
    }
}